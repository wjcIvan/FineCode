# coding=utf-8
import os
import sys
import cv2
import time
import random
from selenium import webdriver
from selenium.webdriver import ActionChains


# reload(sys)
# sys.setdefaultencoding('utf-8')


# 初始化
def init_driver():
    # 新建selenium浏览器对象
    options = webdriver.ChromeOptions()
    options.add_argument('--disable-gpu')
    options.add_argument('--hide-scrollbars')
    # options.add_argument('blink-settings=imagesEnabled=false')
    options.add_argument('--no-sandbox')
    options.add_experimental_option('excludeSwitches', ['enable-logging'])
    options.add_argument('--headless')
    driver = webdriver.Chrome(chrome_options=options)
    # driver = webdriver.Chrome()
    # 网站查询页面
    url = 'https://beian.miit.gov.cn/#/Integrated/recordQuery'
    # 浏览器访问查询页面
    driver.get(url)
    # 等待3s用于加载脚本文件 隐式等待
    driver.implicitly_wait(3)
    return driver


# 搜索操作
def search(driver, domain):
    # 隐藏悬浮框 分辨率较小时会挡住搜索按钮
    js = 'document.getElementsByClassName("float-box")[0].remove();'
    driver.execute_script(js)

    # 搜索框输入域名
    driver.find_element_by_xpath('//*[@id="app"]/div/header/div[3]/div/div/input').send_keys(domain)
    # 点击搜索按钮，弹出滑动验证码
    btn = driver.find_element_by_xpath('//*[@id="app"]/div/header/div[3]/div/button')
    btn.click()

    # 点击搜索后 会有延迟 所以要等待 直到滑动验证框出现
    slider = driver.find_element_by_xpath('//*[@id="slidingPictures"]').get_attribute("style")
    while "none" in slider:
        time.sleep(1)
        slider = driver.find_element_by_xpath('//*[@id="slidingPictures"]').get_attribute("style")
    return driver


# 滑动验证操作
def operator(driver):
    if os.path.isdir("photo"):
        pass
    else:
        os.mkdir("photo")
    try:
        # 获取拼图并截屏保存
        driver.find_element_by_id('sildeImg').screenshot('photo/temp_temp.png')
    except:
        # 给次机会
        print("给次机会")
        time.sleep(3)
        driver.find_element_by_id('sildeImg').screenshot('photo/temp_temp.png')

    # 隐藏拼图
    js = 'document.getElementById("sildeImg").style.display="none";'
    driver.execute_script(js)

    # 获取背景图并截屏保存
    driver.find_element_by_id('bgImg').screenshot('photo/temp_target.png')
    # 显示拼图 没啥意义 为了好看
    js = 'document.getElementById("sildeImg").style.display="block";'
    driver.execute_script(js)

    # 模糊匹配两张图片 计算出拖动距离
    # move = FindPic('photo/temp_target.png', 'photo/temp_temp.png')
    move = matchImg('photo/temp_target.png', 'photo/temp_temp.png')
    # 这里可以根据情况自己微调
    distance = move

    # 获取拖动的箭头
    draggable = driver.find_element_by_xpath('//*[@class="sildeblock"]')
    # 按住左键
    ActionChains(driver).click_and_hold(draggable).perform()

    # 获取轨迹 如果直接一步拉到位 无法通过系统校验
    track_list = get_track(distance)
    for track in track_list:
        ActionChains(driver).move_by_offset(xoffset=track, yoffset=0).perform()

    # 释放鼠标
    ActionChains(driver).release().perform()
    time.sleep(3)
    return driver


# 获取备案信息dict
def getRecordDict(driver):
    i = 0
    # 获取滑动验证框的div 当display:none时 说明通过了校验 block说明未通过 再来一次 五次后放弃
    slider = driver.find_element_by_xpath('//*[@id="slidingPictures"]').get_attribute("style")
    time.sleep(3)
    while "block" in slider:
        if i < 5:
            driver = operator(driver)
            slider = driver.find_element_by_xpath('//*[@id="slidingPictures"]').get_attribute("style")
            i += 1
        else:
            break
    if i == 5:
        driver.quit()
        return None

    # 获取结果数组
    result = driver.find_elements_by_xpath('//*[@class="cell el-tooltip"]')
    recordDict = None
    if len(result) == 7:
        recordDict = {"main": result[0].text, "mainType": result[1].text, "record": result[2].text,
                      "websiteName": result[3].text,
                      "websiteHome": result[4].text, "time": result[5].text}

    print(recordDict)
    return recordDict


# 另一种算法
def FindPic(target, template):
    """
    找出图像中最佳匹配位置
    :param target: 目标即背景图
    :param template: 模板即需要找到的图
    :return: 返回最佳匹配及其最差匹配和对应的坐标
    """
    target_rgb = cv2.imread(target)
    target_gray = cv2.cvtColor(target_rgb, cv2.COLOR_BGR2GRAY)
    template_rgb = cv2.imread(template, 0)
    res = cv2.matchTemplate(target_gray, template_rgb, cv2.TM_CCOEFF_NORMED)
    value = cv2.minMaxLoc(res)
    max_loc = value[2][0]
    return max_loc


# 模糊匹配两张图片 获取最大匹配坐标的x坐标
def matchImg(imgPath1, imgPath2):
    # 原始图像，灰度
    # 最小阈值100,最大阈值500
    img1 = cv2.imread(imgPath1, 0)
    blur1 = cv2.GaussianBlur(img1, (3, 3), 0)
    canny1 = cv2.Canny(blur1, 100, 500)
    cv2.imwrite('photo/temp1.png', canny1)
    img2 = cv2.imread(imgPath2, 0)
    blur2 = cv2.GaussianBlur(img2, (3, 3), 0)
    canny2 = cv2.Canny(blur2, 100, 500)
    cv2.imwrite('photo/temp2.png', canny2)
    target = cv2.imread('photo/temp1.png')
    template = cv2.imread('photo/temp2.png')
    # 匹配拼图
    result = cv2.matchTemplate(target, template, cv2.TM_CCOEFF_NORMED)
    # 归一化
    cv2.normalize(result, result, 0, 1, cv2.NORM_MINMAX, -1)
    min_val, max_val, min_loc, max_loc = cv2.minMaxLoc(result)
    return max_loc[0]


# 主函数
def main(domain):
    driver = init_driver()
    driver = search(driver, domain)
    driver = operator(driver)
    recordDict = getRecordDict(driver)
    driver.quit()

    filepath = "photo"
    del_list = os.listdir(filepath)
    for f in del_list:
        file_path = os.path.join(filepath, f)
        os.remove(file_path)
    return recordDict


# 根据缺口的位置模拟x轴移动的轨迹
def get_track(length):
    list = []
    # 间隔通过随机范围函数来获得,每次移动一步或者两步
    x = random.randint(1, 3)
    # 生成轨迹并保存到list内
    # 前面步子大一点
    while length - x >= 30:
        list.append(x)
        length = length - x
        x = random.randint(10, 30)
    # 这里步子小一点
    while length - x >= 5:
        list.append(x)
        length = length - x
        x = random.randint(2, 8)
    # 最后五步都是一步步移动
    for i in range(length):
        list.append(1)
    return list


if __name__ == '__main__':
    main(sys.argv[1])
