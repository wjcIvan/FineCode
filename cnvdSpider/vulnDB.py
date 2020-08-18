#!/usr/bin/env python3
# -*- encoding: utf-8 -*-
# Created on 2019-12-20 15:20:30
# Project: VulDB_Spider
# Author: KEYONE @ https://github.com/hi-KK

import requests
import js2py
from lxml import etree
import csv
import time
import random
# from collections import OrderedDict
import codecs
from datetime import date
from multiprocessing.dummy import Pool as Threadpool
# from sqlalchemy.ext.declarative import declarative_base
# from sqlalchemy import Column, Integer, String, ForeignKey, TEXT, Index, DATE
# from sqlalchemy.orm import sessionmaker, relationship
# from sqlalchemy import create_engine
# from selenium import webdriver
# from selenium.webdriver.chrome.options import Options
# import ast
# from fake_useragent import UserAgent

# Base = declarative_base()


# class Cnvdtable(Base):
#     __tablename__ = 'cn_table'

#     id = Column(Integer, primary_key=True)
#     cn_url = Column(String(64))
#     cn_title = Column(TEXT)
#     cnvd_id = Column(String(32))
#     pub_date = Column(DATE)
#     hazard_level = Column(String(32))
#     cn_impact = Column(TEXT)
#     cve_id = Column(String(32))
#     cn_describe = Column(TEXT)
#     cn_types = Column(String(64))
#     cn_reference = Column(String(512))
#     cn_solution = Column(String(512))
#     cn_patch = Column(TEXT)

#     __table_args__ = (
#         Index('cn_url', 'cnvd_id'),
#     )


# engine = create_engine(
#     "mysql+pymysql://root:root@localhost/scrapy?charset=utf8", max_overflow=5)

# Base.metadata.create_all(engine)
# Session = sessionmaker(bind=engine)
# session = Session()


class Cnvdspider(object):
    def __init__(self):
        agents = [
            "Mozilla/5.0 (Linux; U; Android 2.3.6; en-us; Nexus S Build/GRK39F) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Avant Browser/1.2.789rel1 (http://www.avantbrowser.com)",
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/532.5 (KHTML, like Gecko) Chrome/4.0.249.0 Safari/532.5",
            "Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/532.9 (KHTML, like Gecko) Chrome/5.0.310.0 Safari/532.9",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/534.7 (KHTML, like Gecko) Chrome/7.0.514.0 Safari/534.7",
            "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US) AppleWebKit/534.14 (KHTML, like Gecko) Chrome/9.0.601.0 Safari/534.14",
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.14 (KHTML, like Gecko) Chrome/10.0.601.0 Safari/534.14",
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.20 (KHTML, like Gecko) Chrome/11.0.672.2 Safari/534.20",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/534.27 (KHTML, like Gecko) Chrome/12.0.712.0 Safari/534.27",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.24 Safari/535.1",
            "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.36 Safari/535.7",
            "Mozilla/5.0 (Windows; U; Windows NT 6.0 x64; en-US; rv:1.9pre) Gecko/2008072421 Minefield/3.0.2pre",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.0.10) Gecko/2009042316 Firefox/3.0.10",
            "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-GB; rv:1.9.0.11) Gecko/2009060215 Firefox/3.0.11 (.NET CLR 3.5.30729)",
            "Mozilla/5.0 (Windows; U; Windows NT 6.0; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6 GTB5",
            "Mozilla/5.0 (Windows; U; Windows NT 5.1; tr; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8 ( .NET CLR 3.5.30729; .NET4.0E)",
            "Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
            "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:2.0.1) Gecko/20100101 Firefox/4.0.1",
            "Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:6.0a2) Gecko/20110622 Firefox/6.0a2",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:7.0.1) Gecko/20100101 Firefox/7.0.1",
            "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:2.0b4pre) Gecko/20100815 Minefield/4.0b4pre",
            "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0 )",
            "Mozilla/4.0 (compatible; MSIE 5.5; Windows 98; Win 9x 4.90)",
            "Mozilla/5.0 (Windows; U; Windows XP) Gecko MultiZilla/1.6.1.0a",
            "Mozilla/2.02E (Win95; U)",
            "Mozilla/3.01Gold (Win95; I)",
            "Mozilla/4.8 [en] (Windows NT 5.1; U)",
            "Mozilla/5.0 (Windows; U; Win98; en-US; rv:1.4) Gecko Netscape/7.1 (ax)",
            "HTC_Dream Mozilla/5.0 (Linux; U; Android 1.5; en-ca; Build/CUPCAKE) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (hp-tablet; Linux; hpwOS/3.0.2; U; de-DE) AppleWebKit/534.6 (KHTML, like Gecko) wOSBrowser/234.40.1 Safari/534.6 TouchPad/1.0",
            "Mozilla/5.0 (Linux; U; Android 1.5; en-us; sdk Build/CUPCAKE) AppleWebkit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (Linux; U; Android 2.1; en-us; Nexus One Build/ERD62) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 1.5; en-us; htc_bahamas Build/CRB17) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (Linux; U; Android 2.1-update1; de-de; HTC Desire 1.19.161.5 Build/ERE27) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Sprint APA9292KT Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 1.5; de-ch; HTC Hero Build/CUPCAKE) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-us; ADR6300 Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 2.1; en-us; HTC Legend Build/cupcake) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 1.5; de-de; HTC Magic Build/PLAT-RC33) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1 FirePHP/0.3",
            "Mozilla/5.0 (Linux; U; Android 1.6; en-us; HTC_TATTOO_A3288 Build/DRC79) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (Linux; U; Android 1.0; en-us; dream) AppleWebKit/525.10  (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2",
            "Mozilla/5.0 (Linux; U; Android 1.5; en-us; T-Mobile G1 Build/CRB43) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari 525.20.1",
            "Mozilla/5.0 (Linux; U; Android 1.5; en-gb; T-Mobile_G2_Touch Build/CUPCAKE) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Droid Build/FRG22D) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 2.0; en-us; Milestone Build/ SHOLS_U2_01.03.1) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 2.0.1; de-de; Milestone Build/SHOLS_U2_01.14.0) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 3.0; en-us; Xoom Build/HRI39) AppleWebKit/525.10  (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2",
            "Mozilla/5.0 (Linux; U; Android 0.5; en-us) AppleWebKit/522  (KHTML, like Gecko) Safari/419.3",
            "Mozilla/5.0 (Linux; U; Android 1.1; en-gb; dream) AppleWebKit/525.10  (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2",
            "Mozilla/5.0 (Linux; U; Android 2.0; en-us; Droid Build/ESD20) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 2.1; en-us; Nexus One Build/ERD62) AppleWebKit/530.17 (KHTML, like Gecko) Version/4.0 Mobile Safari/530.17",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-us; Sprint APA9292KT Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-us; ADR6300 Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 2.2; en-ca; GT-P1000M Build/FROYO) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1",
            "Mozilla/5.0 (Linux; U; Android 3.0.1; fr-fr; A500 Build/HRI66) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13",
            "Mozilla/5.0 (Linux; U; Android 3.0; en-us; Xoom Build/HRI39) AppleWebKit/525.10  (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2",
            "Mozilla/5.0 (Linux; U; Android 1.6; es-es; SonyEricssonX10i Build/R1FA016) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
            "Mozilla/5.0 (Linux; U; Android 1.6; en-us; SonyEricssonX10i Build/R1AA056) AppleWebKit/528.5  (KHTML, like Gecko) Version/3.1.2 Mobile Safari/525.20.1",
        ]

        self.headers = {"User-Agent": agents[random.randint(0, 60)]}

        # self.headers = {'User-Agent': UserAgent().random}
        print(self.headers)
        # self.headers = {"User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36"}
        # 如果从某处断线了，可以更改起始的url地址
        # self.start_url = "http://www.cnvd.org.cn/flaw/list.htm"
        self.count = 0
        self.cookies = self.get_cookies()

    # def get_cookies1(self):
    #     options = Options()
    #     # 加上下面两行，解决报错
    #     options.add_argument('--no-sandbox')
    #     options.add_argument('--disable-dev-shm-usage')
    #     driver = webdriver.Chrome(options=options)
    #     driver.get(
    #         "https://www.cnvd.org.cn/flaw/list.htm?max=20&offset=20")  # 设置每次ChromeDriver访问的初始页面用来更新cookie，以绕过cnvd爬虫限制
    #     cj = driver.get_cookies()
    #     print(cj)
    #     cookie = ''
    #     for c in cj:
    #         cookie += "'" + c['name'] + "':'" + c['value'] + "',"
    #     cookie = ast.literal_eval('{' + cookie + '}')
    #     print(cookie)
    #     driver.quit()
    #     return cookie

    def get_cookies(self):
        resp = requests.get(
            "https://www.cnvd.org.cn/flaw/list.htm?max=20&offset=20")  # 设置每次ChromeDriver访问的初始页面用来更新cookie，以绕过cnvd爬虫限制
        cookie = requests.utils.dict_from_cookiejar(resp.cookies)
        print(cookie)
        return cookie

    def parse(self, i):
        time.sleep(random.randint(2, 5))
        self.count += 1
        print(self.count)
        if (self.count == 5):
            self.cookies = self.get_cookies()
            self.count = 0
        url = 'https://www.cnvd.org.cn/flaw/list.htm?%s' % str(i)
        # 当前的CNVD设置了只能POST提交数据，这里把max设置成100，这也是cnvd能在一个页面显示的最大漏洞信息条数，默认是20条，这样能减少查询页数。
        #html = requests.post(url, data={'max': 100, 'offset': str(i)}, headers=self.headers,
        #                     cookies=self.cookies)
        # url = 'https://www.cnvd.org.cn/flaw/list.htm'

        print(self.cookies)
        self.cookies = self.cookies
        htmlTmp = requests.post(url, data={'max': 100, 'offset': str(i)}, headers=self.headers, cookies=self.cookies)
        html = htmlTmp.content.decode('UTF-8', 'ignore').strip().strip(b'\x00'.decode())
        if (htmlTmp.status_code == 521):
            time.sleep(random.randint(2, 5))
            cookie2 = self.decrypt_cookie(html)
            cookie2 = cookie2.strip('\'').split(";")[0]
            self.cookies[cookie2.split("=")[0]] = cookie2.split("=")[1]
            print(self.cookies)
            html = requests.post(url, data={'max': 100, 'offset': str(i)}, headers=self.headers,
                                    cookies=self.cookies)
        print(html)
        html = etree.HTML(html)
        print(html)
        return html

    def parse2(self, url):
        time.sleep(random.randint(2, 5))
        self.count += 1
        print(self.count)
        if (self.count == 5):
            self.cookies = self.get_cookies()
            self.count = 0
        html = requests.get(url, headers=self.headers,
                            cookies=self.cookies).content.decode()
        html = etree.HTML(html)
        return html

    def get_list_url(self, html):
        list_url = html.xpath("//div[@id='flawList']/tbody/tr/td[1]/a/@href")
        if list_url is None:
            list_url = html.xpath(
                "//div[@class='blkContainerPblk']//table[@class='tlist']/tbody/tr/td[1]/a/@href")
        for url in list_url:
            url = "http://www.cnvd.org.cn" + url
            self.parse_detail(url)
        # next_url = html.xpath(
        #     "//a[@class='nextLink']/@href")[0] if html.xpath("//a[@class='nextLink']/@href") else None
        # if next_url:
        #     next_url = "http://www.cnvd.org.cn" + next_url
        # return next_url

    def parse_detail(self, url):
        time.sleep(random.randint(2, 5))
        html = self.parse2(url)
        # item = OrderedDict()  # 如果要存入csv文档，建议用有序字典
        item = {}
        # URL
        item["cn_url"] = url
        # 获取漏洞标题
        item["cn_title"] = html.xpath(
            "//div[@class='blkContainerPblk']/div[@class='blkContainerSblk']/h1/text()")
        if item["cn_title"]:
            item["cn_title"] = html.xpath("//div[@class='blkContainerPblk']/div[@class='blkContainerSblk']/h1/text()")[
                0].strip()
        else:
            item["cn_title"] = 'Null'

        # 获取漏洞公开日期
        # item["date"] = html.xpath("//td[text()='公开日期']/following-sibling::td[1]/text()")
        item["pub_date"] = html.xpath(
            "//div[@class='tableDiv']/table[@class='gg_detail']//tr[2]/td[2]/text()")
        if item["pub_date"]:
            item["pub_date"] = "".join(
                [i.strip() for i in item["pub_date"]])
        #    item["pub_date"] = self.convertstringtodate(item["pub_date"])
        else:
            item["pub_date"] = '2000-01-01'
        #    item["pub_date"] = self.convertstringtodate(item["pub_date"])

        # 获取漏洞危害级别
        item["hazard_level"] = html.xpath(
            "//td[text()='危害级别']/following-sibling::td[1]/text()")
        if item["hazard_level"]:
            item["hazard_level"] = "".join(
                [i.replace("(", "").replace(")", "").strip() for i in item["hazard_level"]])
        else:
            item["hazard_level"] = 'Null'

        # 获取漏洞影响的产品
        item["cn_impact"] = html.xpath(
            "//td[text()='影响产品']/following-sibling::td[1]/text()")
        if item["cn_impact"]:
            item["cn_impact"] = "   ;   ".join(
                [i.strip() for i in item["cn_impact"]])
        else:
            item["cn_impact"] = 'Null'

        # 获取cnvd id
        item["cnvd_id"] = html.xpath(
            "//td[text()='CNVD-ID']/following-sibling::td[1]/text()")
        if item["cnvd_id"]:
            item["cnvd_id"] = "".join(
                [i.strip() for i in item["cnvd_id"]])
        else:
            item["cnvd_id"] = 'Null'

        # 获取cve id
        item["cve_id"] = html.xpath(
            "//td[text()='CVE ID']/following-sibling::td[1]//text()")
        if item["cve_id"]:
            item["cve_id"] = "".join(
                [i.strip() for i in item["cve_id"]])
        else:
            item["cve_id"] = 'Null'

        # 获取漏洞类型
        item["cn_types"] = html.xpath(
            "//td[text()='漏洞类型']/following-sibling::td[1]//text()")
        if item["cn_types"]:
            item["cn_types"] = "".join(
                [i.strip() for i in item["cn_types"]])
        else:
            item["cn_types"] = 'Null'

        # 获取漏洞描述
        item["cn_describe"] = html.xpath(
            "//td[text()='漏洞描述']/following-sibling::td[1]//text()")
        if item["cn_describe"]:
            item["cn_describe"] = "".join(
                [i.strip() for i in item["cn_describe"]]).replace("\u200b", "")
        else:
            item["cn_describe"] = 'Null'

        # 获取漏洞的参考链接
        item["cn_reference"] = html.xpath(
            "//td[text()='参考链接']/following-sibling::td[1]/a/@href")
        if item["cn_reference"]:
            item["cn_reference"] = item["cn_reference"][0].replace('\r', '')
        else:
            item["cn_reference"] = 'Null'

        # 获取漏洞的解决方案
        item["cn_solution"] = html.xpath(
            "//td[text()='漏洞解决方案']/following-sibling::td[1]//text()")
        if item["cn_solution"]:
            item["cn_solution"] = "".join(
                [i.strip() for i in item["cn_solution"]])
        else:
            item["cn_solution"] = 'Null'

        # 获取漏洞厂商补丁
        item["cn_patch"] = html.xpath(
            "//td[text()='厂商补丁']/following-sibling::td[1]/a")
        if item["cn_patch"]:
            for i in item["cn_patch"]:
                list = []
                try:
                    list.append(i.xpath("./text()")[0])
                    list.append("http://www.cnvd.org.cn" + i.xpath("./@href")[0])
                    item["cn_patch"] = list[0] + ':' + list[1]
                except IndexError:
                    pass
        else:
            item["cn_patch"] = 'Null'

        print(item)
        # 保存数据到csv
        self.save_data(item)

    def convertstringtodate(self, stringtime):
        "把字符串类型转换为date类型"
        #  把数据里的时间格式替换成数据库需要的格式。日期格式，便于后期提取数据，
        if stringtime[0:2] == "20":
            year = stringtime[0:4]
            month = stringtime[4:6]
            day = stringtime[6:8]
            if day == "":
                day = "01"
            begintime = date(int(year), int(month), int(day))
            return begintime
        else:
            year = "20" + stringtime[0:2]
            month = stringtime[2:4]
            day = stringtime[4:6]

            begintime = date(int(year), int(month), int(day))
            return begintime

    def save_data(self, item):
        # 数据保存进csv，此处可以打开，存txt类似
        with open("./cnvd-1290ye.csv", "a") as f:
            writer = csv.writer(f, codecs.BOM_UTF8)
            c = []
            for i in item.values():
                c.append(i)
            writer.writerow(c)

        # dic = dict(item)
        # obc = Cnvdtable(
        #     cn_url=dic['cn_url'],
        #     cn_title=dic['cn_title'],
        #     cnvd_id=dic['cnvd_id'],
        #     cve_id=dic['cve_id'],
        #     pub_date=dic['pub_date'],
        #     cn_types=dic['cn_types'],
        #     hazard_level=dic['hazard_level'],
        #     cn_impact=dic['cn_impact'],
        #     cn_describe=dic['cn_describe'],
        #     cn_reference=dic['cn_reference'],
        #     cn_solution=dic['cn_solution'],
        #     cn_patch=dic['cn_patch'],
        # )
        # session.add(obc)
        # session.commit()
        # print("\n"+dic['cn_title']+" ==============存储成功\n")

    def run(self):

        # 每次 i 递增100位
        for i in range(128900, 129900, 20):  # 如果因为一些原因导致脚本报错中断，重新运行时需要重新设置范围，根据post页面信息来定位报错的页数
            html = self.parse(i)
            print("页数:" + str(i))  # 页数
            next_url = self.get_list_url(html)
            print(next_url)

    #解密js获取cookie
    #
    def decrypt_cookie(self, data):
        func_data = "function getClearance(){" + data + "};"
        func_data = func_data.replace("</script>", "")
        func_data = func_data.replace("eval", "return")
        func_data = func_data.replace("<script>", "")

        real_data = js2py.eval_js(func_data)
        str_data = str(real_data())
        str_data = str_data.strip('\'')

        index1 = str_data.find("document.")
        index2 = str_data.find("};if((")
        data = str_data[index1:index2].replace("document.cookie", "cookie")
        data = "function getClearance(){" + data + ";return cookie;}"
        data = js2py.eval_js(data)
        return data()

if __name__ == "__main__":
    a = Cnvdspider()
    pool = Threadpool(1)  # 单线程跑的慢，但是基本很稳定没有被cnvd封杀。本次跑完整个cnvd库大概十天左右，期间网络波动中断需要维护代码，及爬虫重新爬的页面范围。
    a.run()
    # pool.map(a.run(),self.parse())
    pool.close()
    pool.join()


