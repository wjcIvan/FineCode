# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://doc.scrapy.org/en/latest/topics/item-pipeline.html
# import pymongo
# import sys
# import time
import datetime
import pymysql
# import MySQLdb.cursors
# from scrapy.conf import settings
# from scrapy.exceptions import DropItem
from twisted.enterprise import adbapi
from scrapy.utils.project import get_project_settings

settings = get_project_settings()


class MavenscrapyPipeline(object):

    def __init__(self):
        pass
        self.dbpool = adbapi.ConnectionPool('pymysql', host=settings['MYSQL_HOST'], port=settings['MYSQL_PORT'],
                                            user=settings['MYSQL_USER'], passwd=settings['MYSQL_PASSWORD'],
                                            db=settings['MYSQL_DBNAME'], cursorclass=pymysql.cursors.DictCursor,
                                            charset='utf8')

    def process_item(self, item, spider):
        query = self.dbpool.runInteraction(self._conditional_insert, item)
        query.addErrback(self._handle_error)
        return item

    def _conditional_insert(self, tx, item):
        tx.execute(
            "INSERT IGNORE INTO `scap_test`.`sys_maven_repo` ( `md5`,`jar_name`, `jar_url`, `update_time`,`jar_pom`) "
            "VALUES ('{}','{}','{}','{}','{}');".format(
                item['jar_md5'],
                item['jar_name'],
                item['jar_url'],
                datetime.datetime.now(),
                item['jar_pom']))
        print(item['jar_url'] + '[+]Records insert succeeded!')

    def _handle_error(self, e):
        print(u"[!]database error !!!", e)
