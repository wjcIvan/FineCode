# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class MavenscrapyItem(scrapy.Item):
    jar_md5 = scrapy.Field()
    jar_name = scrapy.Field()
    jar_url = scrapy.Field()
    jar_pom = scrapy.Field()
    # define the fields for your item here like:
    # name = scrapy.Field()
    # groupid = scrapy.Field()  # jar包的groupid
    # artifactid = scrapy.Field()  # artifactid
    # version = scrapy.Field()  # 版本
    # version_url = scrapy.Field()  # 版本链接
    # jar_source_download_url = scrapy.Field()  # jar_source的下载链接
    # jar_md5 = scrapy.Field()  # jar的MD5
    # jar_sha1 = scrapy.Field()  # jar的sha1
    # jar_download_url = scrapy.Field()  # jar的下载链接
    # pom_download_url = scrapy.Field()  # pom的下载链接

