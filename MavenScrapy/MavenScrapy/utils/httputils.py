# -*- coding: utf-8 -*-
"""
    Author: Luomingfa
    Date: 2018.06
"""
import re

def cookies_dict_from_str(cookie):
    """
    从浏览器或者request headers中拿到cookie字符串，提取为字典格式的cookies
    """
    if cookie:
        return dict([l.split("=", 1) for l in cookie.split("; ")])
    else:
        return None


def headers_dict_from_raw(header_raw):
    """
    通过原生请求头获取请求头字典
    :param header_raw: {str} 浏览器请求头
    :return: {dict} headers
    """
    if header_raw:
        try:
            headers_dict = dict(line.split(": ", 1) for line in header_raw.strip().split("\r\n"))
            return headers_dict
        except Exception, e:
            print(u'http header 转换异常,内容：\n{}'.format(header_raw))
            return None
    else:
        return None


def urlsimilar(url):
    """
    根据算法返回一个hash值，这个hash值也就是该URL的hash相似度。
    如果两个URL计算出的hash值最后比较相等，我们则可以判断两个URL是具有较高的相似度的。
    :param url:
    :return: hash值
    """
    import hashlib
    import urlparse
    filter_file = ['.css', '.html', '.shtml', '.js', '.jpg', '.jpeg', '.gif', '.png', '.bmp', '.swf', '.svg', '.apk',
                   '.ipa', '.ico', '.woff', '.ttf', '.zip', '.so', '.jar', '.json', '.gz', '.mp4', '.m3u8', '.svc',
                   '.woff', '.deb', '.bz2', '.gpg', '.lzma', '.mp3', '.xml', '.txt', '.pbf', '.htm']
    hash_size = 199999
    tmp = urlparse.urlparse(url.lower())
    scheme = tmp.scheme
    netloc = tmp.netloc
    path = tmp.path[1:]
    query = tmp.query
    # First get tail
    if len(path.split('/')) > 1:
        tail_arr = path.split('/')[-1].split('.')
        if len(tail_arr[0]):
            suffix = "." + tail_arr[0]
            if suffix in filter_file:
                tail = suffix
            else:
                tail = ".".join(tail_arr)
        else:
            tail = tail_arr[-1]
    elif len(path.split('/')) == 1:
        # 解决下面两个URL的相似度问题
        # http://www.cdta.gov.cn/show-12-89-1.html
        # http://www.cdta.gov.cn/show-13-36-1.html
        tail_arr = path.split('/')[-1].split('.')
        if len(tail_arr[0]):
            suffix = "." + tail_arr[0]
            if suffix in filter_file:
                tail = suffix
            else:
                tail = ".".join(tail_arr)
        else:
            tail = tail_arr[-1]
    else:
        tail = '1'
    # Second get path_length
    path_length = len(path.split('/')) - 1
    # Third get directy list except last
    path_list = path.split('/')[:-1] + [tail]
    # Fourth hash
    path_value = 0
    for i in range(path_length + 1):
        if path_length - i == 0:
            path_value += hash(path_list[path_length - i]) % 98765
        else:
            path_value += len(path_list[path_length - i]) * (10 ** (i + 1))
    query_value = 0
    if len(query.split('&')) > 1:
        tmp_query = re.sub(r'=([\w-]+)', "", query)
        tmp_query_arr = tmp_query.split('&')
        tmp_query_arr.sort()
        query_value = hash(hashlib.new("md5", '|'.join(tmp_query_arr)).hexdigest()) % hash_size
    # get host hash value
    netloc_value = hash(hashlib.new("md5", netloc).hexdigest()) % hash_size
    url_value = hash(hashlib.new("md5", str(path_value + netloc_value + query_value)).hexdigest()) % hash_size
    return url_value


if __name__ == '__main__':
    # cookie = '''SVR_SSL=B; JSESSIONID=2B4C290C93AC5E44411BB8CB8BE3EBFF; SVR_HTTP=F; Hm_lvt_bf8738513d38a2418063f7b873084c15=1530153041; Hm_lpvt_bf8738513d38a2418063f7b873084c15=1530515310'''
    # cookie = '.ASPXAUTH=DB090E9078379955674E5319840433B166257B20BE8D207AC69602899EC0CC6DB3546C6C07140290F901B0128F1E721C40EF96D4773B3202DBDDDE76470A34E5D4F239739A03E08388CD6576A2F30B915E459E6F430FCFBE7859EB15A47DCE5C68D458494B524A8741C29A5E4A195D05DB09B1A420557EE60DBF2E51493D4609CED61FD80E91908E9F04ABB289C3993284D4A44E0429530805752977445C04F9; SERVERID=3040ab6b750f7a01ec3030a251e35ce3|1530695417|1530694435'
    # import json
    #
    # print(json.dumps(cookies_dict_from_str(cookie)))

    # header = '''host: xxx\r\nConnection: keep-alive\r\nAccept: */*\r\nX-Requested-With: XMLHttpRequest\r\nUser-Agent: Mozilla/5.0 (Linux; Android 4.4.4; AOSP on HammerHead Build/KTU84P; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/044200 Mobile Safari/537.36 MicroMessenger/6.6.7.1320(0x26060739) NetType/WIFI Language/en\r\nReferer: https://consumer.fcbox.com/customerApp/pages/appLoad.html\r\nAccept-Encoding: \r\nAccept-Language: en-US\r\nCookie: Hm_lvt_bf8738513d38a2418063f7b873084c15=1530153041; Hm_lpvt_bf8738513d38a2418063f7b873084c15=1530515180\r\n'''
    # print(headers_dict_from_raw(header))
    # print(headers_dict_from_raw(''))

    print(urlsimilar('http://www.cdta.gov.cn/show-12-89-1.html'))
    print(urlsimilar('http://www.cdta.gov.cn/show-13-36-1.html'))
    print(urlsimilar('http://www.baidu.com/blog/admin/test.php'))
