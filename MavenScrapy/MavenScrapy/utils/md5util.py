# -*- coding: utf-8 -*-
"""
    Author: Luomingfa
    Date: 2018.06
"""

import hashlib
import json


def str_md5(string):
    m = hashlib.md5()
    m.update(string.encode("utf-8"))
    md5value = m.hexdigest()
    return md5value


def obj_md5(obj):
    text = json.dumps(obj)
    return str_md5(text)


if __name__ == '__main__':
    print(str_md5(r"""{'tab_names': 'html he1ad meta meta meta meta meta meta title link link link link script body div div div a img ul li a li a div div div h4 ul li a li a li a li a li a div h4 ul li a li a li a li a div h4 ul li a li a li a li a li a li a li a li a div a a label input span i i i div div div p p small img div div div ul li a li a li a li a div h3 div p div div img p ul li li li li div img p ul li li li li div img p ul li li li div div div img p ul li li li div img p ul li li li li li div img p ul li li li div div div p ul li a li a li a li a div p ul li a li a li a li a li a div p ul li a li a li a li a li a div p ul li li li li li a div p img p i div p a img p i div p span a a a p script script div div a i p div i p span div i p script script script script script',
 # 'tab_names_md5': '20f0bc875c5d63f6110f778bc07090c8','url': 'http://www.secidea.com/smartfire/product.html'}"""))