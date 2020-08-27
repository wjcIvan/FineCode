# -*- coding: utf-8 -*-
import re

import scrapy_redis
import requests
import scrapy
from MavenScrapy.items import MavenscrapyItem

# from items import MavenscrapyItem
from MavenScrapy.utils.md5util import str_md5


class MavenSpider(scrapy.Spider):
    name = 'maven'
    # allowed_domains = ['http://central.maven.org/maven2/'] #允许爬取多个页面
    # start_urls = ['https://repo1.maven.org/maven2/']
    start_urls = ['https://repo1.maven.org/maven2/']
    item = MavenscrapyItem()

    # def start_requests(self):  # 控制爬虫发出的第一个请求
    #     proxy = "http://192.168.40.112:1080"
    #     yield scrapy.Request(self.start_urls[0], meta={"proxy": proxy})

    def parse(self, response):
        quote = response.css('#contents').css('a::attr("href")').extract()  # 解析maven的初始网站
        urllist = []
        for i in quote:
            if '../' not in i and '.xml' not in i and '.txt' not in i and '/' in i:
                urllist.append(self.start_urls[0] + i)
                yield scrapy.Request(url=self.start_urls[0] + i, callback=self.parsedetail,
                                     meta={"url": self.start_urls[0] + i})

    def parsedetail(self, response):
        quote = response.css('#contents').css('a::attr("href")').extract()
        detailurl = response.meta['url']
        for i in quote:
            version_url = detailurl + i
            if "../" in i or '.xml' in i or '.txt' in i:
                continue

            if i.endswith("javadoc.jar") or i.endswith("sources.jar") or i.endswith(
                    "test.jar") or i.endswith("tests.jar") or i.endswith("jar-with-dependencies.jar"):
                continue

            if i.endswith(".jar"):
                # try:
                #     MavenSpider.item['jar_md5'] = requests.get(version_url + ".md5").text
                # except Exception as e:
                #     try:
                #         MavenSpider.item['jar_md5'] = requests.get(version_url + ".md5").text
                #     except Exception as e:
                #         try:
                #             MavenSpider.item['jar_md5'] = requests.get(version_url + ".md5").text
                #         except Exception as e:
                MavenSpider.item['jar_md5'] = str_md5(version_url)
                MavenSpider.item['jar_url'] = version_url
                MavenSpider.item['jar_name'] = i
                MavenSpider.item['jar_pom'] = i.replace(".jar", ".pom")
                yield MavenSpider.item
                continue

            if '/' in i:
                yield scrapy.Request(url=detailurl + i, callback=self.parsedetail, meta={"url": detailurl + i})
