# coding:utf-8

import sys
from PyQt5 import QtWidgets

import window
import recordSpider


class MainWindow(object):
    def __init__(self):
        app = QtWidgets.QApplication(sys.argv)
        MainWindow = QtWidgets.QMainWindow()
        self.ui = window.Ui_MainWindow()
        self.ui.setupUi(MainWindow)
        MainWindow.show()
        # 获取文本框内容
        self.ui.pushButton.clicked.connect(self.click_success)
        sys.exit(app.exec_())

    def click_success(self):
        domain = self.ui.textEdit.toPlainText()
        result = recordSpider.main(domain)
        if result is None:
            self.ui.lineEdit.setText("未找到备案")
            self.ui.lineEdit_2.setText("")
            self.ui.lineEdit_3.setText("")
            self.ui.lineEdit_4.setText("")
            self.ui.lineEdit_5.setText("")
            self.ui.lineEdit_6.setText("")
        else:
            self.ui.lineEdit.setText(result["main"])
            self.ui.lineEdit_2.setText(result["mainType"])
            self.ui.lineEdit_3.setText(result["record"])
            self.ui.lineEdit_4.setText(result["websiteName"])
            self.ui.lineEdit_5.setText(result["websiteHome"])
            self.ui.lineEdit_6.setText(result["time"])


if __name__ == "__main__":
    MainWindow()
