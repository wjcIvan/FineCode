import re
import requests
from lxml import etree
import pymongo



def getpages(url, total):
 nowpage = int(re.search('(\d+)', url, re.S).group(1))
 urls = []

 for i in range(nowpage, total + 1):
  link = re.sub('(\d+)', '%s' % i, url, re.S)
  urls.append(link)

 return urls

def spider(url):
 html = requests.get(url)

 selector = etree.HTML(html.text)

 book_name = selector.xpath('//*[@id="container"]/ul/li//div/div[2]/a/text()')
 book_author = selector.xpath('//*[@id="container"]/ul/li//div/div[2]/div/a/text()')

 saveinfo(book_name, book_author)

def saveinfo(book_name, book_author):
 connection = pymongo.MongoClient()
 BookDB = connection.BookDB
 BookTable = BookDB.books

 length = len(book_name)

 for i in range(0, length):
  books = {}
  books['name'] = str(book_name[i]).replace('\n','')
  books['author'] = str(book_author[i]).replace('\n','')
  BookTable.insert_one(books)

if __name__ == '__main__':

  url = 'http://readfree.me/?page=1'
  urls = getpages(url,15)

  for each in urls:
   spider(each)