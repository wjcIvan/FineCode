# coding=utf-8
# python2
# @author wjcIvan
# @creatTime 2020/08/04
# selenium webdriver chrome chrome驱动 环境啥的请自行安装

import json
import time
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
import sys

# linux下使用
# from pyvirtualdisplay import Display

reload(sys)
sys.setdefaultencoding('utf-8')

all_comment_user_dict = {}
all_like_user_dict = {}


# 初始化driver
def init_driver(url):
    chrome_options = Options()
    # linux下开启 --no-sandbox --headless开了也行 其他当摆设
    # chrome_options.add_argument('--headless')
    # chrome_options.add_argument('--no-sandbox')
    # chrome_options.add_argument('--disable-gpu')
    # chrome_options.add_argument('--disable-dev-shm-usage')
    driver = webdriver.Chrome(chrome_options=chrome_options)
    # chrome_options.add_argument("--proxy-server=127.0.0.1:8080")

    # 必须先访问一次
    driver.get(url)

    # 运行get_cookies()后获取的cookie文件
    with open('cookies.txt', 'r') as cookief:
        # 使用json读取cookies 注意读取的是文件 所以用load而不是loads
        cookies_list = json.load(cookief)
        for cookie in cookies_list:
            # 并不是所有cookie都含有expiry 所以要用dict的get方法来获取
            if isinstance(cookie.get('expiry'), float):
                cookie['expiry'] = int(cookie['expiry'])
            driver.add_cookie(cookie)

    # 然后携带cookie再访问一次
    driver.get(url)
    time.sleep(3)
    return driver


# 获取用户list 和 评论list
def tweet_driver(driver):
    # 滑到底部 动弹界面滑10多次到底 显示更多页面 计算过滑10次就行 多给几次保险
    for i in range(12):
        driver.execute_script('window.scrollTo(0,document.body.scrollHeight)')
        # 给页面加载的时间 网速好的话给少点
        time.sleep(3)

    print "滴滴滴 到头了"

    last_time = "今天"
    # 只获取今天和昨天 两天的动弹 可以改成你想要的比如【今天 昨天 前天 08/01】
    while "08/02" not in last_time:
        # 这里可以不滑/sleep 但是不知道为什么偶尔会出错 所以还是滑吧 我也不想的
        driver.execute_script('window.scrollTo(0,document.body.scrollHeight)')
        time.sleep(3)
        # 获取当前界面最后一条动弹的时间
        last_time = driver.find_element_by_xpath("//*[@id='tweetList']/div[1]/div[last()]//*[@class='date']").text
        print last_time
        # 点击 查看更多动弹
        driver.find_element_by_xpath("//a[@class='ui fluid button load-more-button']").click()
        # 给页面加载的时间 网速好的话给少点 自信的话可以不给
        time.sleep(3)

    print "滴滴滴 又到头了"
    print "结束了!!!骗你的,才开始获取！"
    print "开始爬取评论"

    # 获取用户list
    user_list = driver.find_elements_by_xpath("//*[@id='tweetList']/div[1]/div//*[@class='__user']")
    # 获取评论list
    comment_list = driver.find_elements_by_xpath("//*[@id='tweetList']/div[1]/div//a[@class='view']")

    return user_list, comment_list


# 获取评论用户列表 点赞用户列表
def comment_driver(driver):
    # 获取点赞用户列表
    like_user_list = driver.find_elements_by_xpath("//div[@class='ui mini avatar images']/a")

    # 获取评论数 如果为 0 return
    comment_count = driver.find_element_by_xpath(
        "//*[@id='tweetCommentsList']/h3[@class='ui header comments-title']/span").text
    if comment_count == '0':
        return None, like_user_list

    # 先滑三次 这里可以优化一下
    for i in range(3):
        if_end = driver.find_elements_by_xpath("//div[@class='list-container-last-tips']")
        if len(if_end) == 1:
            break
        driver.execute_script('window.scrollTo(0,document.body.scrollHeight)')
        # 给页面加载的时间 网速好的话给少点
        time.sleep(3)

    # 判断评论界面是否需要点击加载更多 判断依据为是否存在class='list-container-last-tips'的div【没有更多内容】
    if_end = driver.find_elements_by_xpath("//div[@class='list-container-last-tips']")
    while len(if_end) != 1:
        # 你都滑完三次了 如果还没有出现 【没有更多内容】的标志 那就说明需要点击【更多评论】
        driver.find_element_by_xpath("//a[@class='ui fluid button load-more-button']").click()
        # 这里可以不滑/sleep 但是不知道为什么偶尔会出错 所以还是滑吧 我也不想的
        driver.execute_script('window.scrollTo(0,document.body.scrollHeight)')
        time.sleep(3)
        # 滑一次取一次
        if_end = driver.find_elements_by_xpath("//div[@class='list-container-last-tips']")

    # 获取评论用户list
    comment_user_list = driver.find_elements_by_xpath(
        "//*[@id='tweetCommentsList']/div[@class='ui feed tweet-comments tweet-comments-list-container']/div//*[@class='__user']")

    return comment_user_list, like_user_list


# 主方法
def main():
    url = 'https://www.oschina.net/tweets'
    print "spider it : ", url
    driver = init_driver(url)
    try:
        # 获取某段时间内 【用户名：动弹数】 字典
        user_dict, comment_set = get_user_name_top_shui(driver)
        # 按照值排序
        user_list_new = sorted(user_dict.iteritems(), key=lambda x: x[1], reverse=True)
        print "开始写入文件"
        write_list('userNameDict.txt', user_list_new)
        write_name('userNameDict2.txt', user_list_new)
        write_comment(comment_set)
        print "写入文件完成"

        for i in comment_set:
            print "spider it : ", i
            driver.get(i)
            time.sleep(3)
            try:
                comment_user_list, like_user_set = get_comment_user_name_top_shui(driver)
            except Exception as e:
                print "出现了异常 " + str(e) + ",跳过"
                continue
            get_like_user_dict_all(like_user_set)
            if comment_user_list is None:
                continue
            get_comment_user_name_dict_all(comment_user_list)

        all_like_user_list_new = sorted(all_like_user_dict.iteritems(), key=lambda x: x[1], reverse=True)
        all_comment_user_list_new = sorted(all_comment_user_dict.iteritems(), key=lambda x: x[1], reverse=True)
        write_list('likeUserNameDict.txt', all_like_user_list_new)
        write_name('likeUserNameDict2.txt', all_like_user_list_new)
        write_list('commentUserNameDict.txt', all_comment_user_list_new)
        write_name('commentUserNameDict2.txt', all_comment_user_list_new)

        # 按权重计分 这一段先随便写写
        s = 0
        top_user_score_dict = {}
        for i in user_list_new:
            if s == 100:
                break
            top_user_score_dict[i[0]] = i[1] * 15
            if i[0] in all_comment_user_dict:
                top_user_score_dict[i[0]] += all_comment_user_dict[i[0]] * 9
            if i[0] in all_like_user_dict:
                top_user_score_dict[i[0]] += all_like_user_dict[i[0]] * 6

            s += 1

        r = 0
        for i in all_comment_user_list_new:
            if r == 100:
                break
            r += 1
            if i[0] in top_user_score_dict:
                continue
            top_user_score_dict[i[0]] = i[1] * 9
            if i[0] in user_dict:
                top_user_score_dict[i[0]] += user_dict[i[0]] * 15
            if i[0] in all_like_user_dict:
                top_user_score_dict[i[0]] += all_like_user_dict[i[0]] * 6

        top_user_score_list_new = sorted(top_user_score_dict.iteritems(), key=lambda x: x[1], reverse=True)
        write_list('userNameList.txt', top_user_score_list_new)
    except Exception as e:
        print "出现了异常 " + str(e) + ",跳过"

    driver.quit()


# 获取用户set
def get_user_name(driver):
    user_set = set()
    user_list = driver.find_elements_by_xpath("//*[@id='tweetList']/div[1]/div//*[@class='__user']")
    for user in user_list:
        if user.text != "":
            user_set.add(user.text)
    return user_set


# 获取用户字典 评论set
def get_user_name_top_shui(driver):
    user_dict = {}
    user_list, comment_list = tweet_driver(driver)
    for user in user_list:
        name = user.text
        if name != "":
            if name in user_dict:
                user_dict[name] += 1
            else:
                user_dict[name] = 1

    comment_set = set()
    for comment in comment_list:
        name = comment.get_attribute('href')
        comment_set.add(name)

    return user_dict, comment_set


# 获取评论用户字典 点赞用户set
def get_comment_user_name_top_shui(driver):
    comment_user_dict = {}
    comment_user_list, like_user_list = comment_driver(driver)
    if comment_user_list is not None:
        for comment_user in comment_user_list:
            name = comment_user.text
            if name != "":
                if name in comment_user_dict:
                    comment_user_dict[name] += 1
                else:
                    comment_user_dict[name] = 1

    # 考虑到动弹点赞可以卡bug 重复点赞 所以先去重
    like_user_set = set()
    for like_user in like_user_list:
        name = like_user.get_attribute('title')
        like_user_set.add(name)

    return comment_user_dict, like_user_set


# 获取所有评论用户字典
def get_comment_user_name_dict_all(comment_user_list):
    if comment_user_list is None:
        return
    global all_comment_user_dict
    for k, v in comment_user_list.items():
        if v < 5:
            v = 1
        elif v < 10:
            v = 2
        else:
            v = 3

        if k in all_comment_user_dict:
            all_comment_user_dict[k] += v
        else:
            all_comment_user_dict[k] = v


# 获取所有点赞用户字典
def get_like_user_dict_all(commentSet):
    global all_like_user_dict
    for i in commentSet:
        if i in all_like_user_dict:
            all_like_user_dict[i] += 1
        else:
            all_like_user_dict[i] = 1


# 需要先运行该方法 手动登录后记录cookie信息 保存到文件中
def get_cookies():
    # 填写webdriver的保存目录
    chrome_options = Options()
    # chrome_options.add_argument('--headless')
    # chrome_options.add_argument('--no-sandbox')
    # chrome_options.add_argument('--disable-gpu')
    # chrome_options.add_argument('--disable-dev-shm-usage')
    driver = webdriver.Chrome(chrome_options=chrome_options)

    # 记得写完整的url 包括http和https
    driver.get('https://www.oschina.net/tweets')

    # 程序打开网页后20秒内手动登陆账户
    # 20s够单身的你登录了吧
    time.sleep(20)

    with open('cookies.txt', 'w') as cookief:
        # 将cookies保存为json格式
        cookief.write(json.dumps(driver.get_cookies()))
    driver.close()


# 输出格式 key = value 
def write_list(file_name, name_list):
    with open(file_name, 'w') as f:
        for i in name_list:
            f.write(i[0] + '=' + str(i[1]) + "\n")


# 输出格式 key 方便我直接复制使用
def write_name(file_name, name_list):
    with open(file_name, 'w') as f:
        for i in name_list:
            f.write(i[0] + "\n")


def write_comment(commentSet):
    with open('commentSet.txt', 'w') as f:
        for i in commentSet:
            f.write(i + "\n")


if __name__ == "__main__":
    try:
        # linux需使用以下注释代码
        # display = Display(visible=0, size=(800, 600))
        # display.start()

        # 首次运行需要get_cookies() 后面可以注释 cookie过期了再重复登录操作
        # 此处也能放在后面 时刻更新cookie文件 避免过期 但没必要
        # get_cookies()
        main()

        # linux需使用以下注释代码
        # display.stop()
    except Exception as e:
        print "出现了异常 " + str(e) + "结束任务"
        sys.exit(0)
