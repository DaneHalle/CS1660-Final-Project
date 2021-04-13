# docker build -t test-gui .
# docker run -e DISPLAY=10.0.0.141:0.0 test-gui
# WINDOWS -> $env:DISPLAY=<YOUR_IP>:0.0

# https://github.com/gdhorne/data-scientists-toolbox

# spyder
# https://github.com/spyder-ide/spyder

# Orange3
# https://orangedatamining.com/download/#windows

# VS Code IDE
# https://code.visualstudio.com/download
# https://linuxize.com/post/how-to-install-visual-studio-code-on-ubuntu-18-04/

# Hadoop
# https://github.com/big-data-europe/docker-hadoop
# https://medium.com/analytics-vidhya/how-to-easily-install-hadoop-with-docker-ad094d556f11

# Tensorflow
# https://github.com/matterport/Mask_RCNN/issues/1328

import tkinter as tk
import os
import atexit

class Application(tk.Frame):
    def __init__(self, master=None):
        super().__init__(master)
        self.master = master
        self.user_frame = None
        self.trigger_frame = None
        self.submit_frame = None
        self.create_widgets()

    def create_widgets(self):
        self.user_frame = tk.Frame(self.master)
        self.user_frame.pack()

        self.rstudio = tk.Button(self.user_frame)
        self.rstudio["text"] = "RStudio"
        self.rstudio["command"] = self.RStudio
        self.rstudio.pack()

        self.spyder = tk.Button(self.user_frame)
        self.spyder["text"] = "Spyder"
        self.spyder["command"] = self.Spyder
        self.spyder.pack()

        self.ibmsas = tk.Button(self.user_frame)
        self.ibmsas["text"] = "IBMSAS"
        self.ibmsas["command"] = self.IBMSAS
        self.ibmsas.pack()

        self.git = tk.Button(self.user_frame)
        self.git["text"] = "Git"
        self.git["command"] = self.Git
        self.git.pack()

        self.jupyter = tk.Button(self.user_frame)
        self.jupyter["text"] = "Jupyter"
        self.jupyter["command"] = self.Jupyter
        self.jupyter.pack()

        self.orange = tk.Button(self.user_frame)
        self.orange["text"] = "Orange"
        self.orange["command"] = self.Orange
        self.orange.pack()

        self.vscodeide = tk.Button(self.user_frame)
        self.vscodeide["text"] = "VSCodeIDE"
        self.vscodeide["command"] = self.VSCodeide
        self.vscodeide.pack()

        self.hadoop = tk.Button(self.user_frame)
        self.hadoop["text"] = "Hadoop"
        self.hadoop["command"] = self.Hadoop
        self.hadoop.pack()

        self.spark = tk.Button(self.user_frame)
        self.spark["text"] = "PySpark"
        self.spark["command"] = self.Spark
        self.spark.pack()

        self.tableau = tk.Button(self.user_frame)
        self.tableau["text"] = "Tableau"
        self.tableau["command"] = self.Tableau
        self.tableau.pack()

        self.sonarcloud = tk.Button(self.user_frame)
        self.sonarcloud["text"] = "SonarCloud"
        self.sonarcloud["command"] = self.SonarCloud
        self.sonarcloud.pack()

        self.tensorflow = tk.Button(self.user_frame)
        self.tensorflow["text"] = "Tensorflow"
        self.tensorflow["command"] = self.Tensorflow
        self.tensorflow.pack()

        self.markdown = tk.Button(self.user_frame)
        self.markdown["text"] = "Markdown"
        self.markdown["command"] = self.Markdown
        self.markdown.pack()

    def RStudio(self):
        os.system("echo . > rstudio")

    def Spyder(self):
        os.system("echo . > spyder")

    def IBMSAS(self):        
        os.system("echo . > ibm")

    def Git(self):
        os.system("echo . > git")

    def Jupyter(self):
        os.system("echo . > jupyter")

    def Orange(self):
        os.system("echo . > orange")

    def VSCodeide(self):
        os.system("echo . > vscode")

    def Hadoop(self):
        os.system("echo . > hadoop")

    def Spark(self):
        os.system("echo . > pyspark")

    def Tableau(self):
        os.system("echo . > tableau")

    def SonarCloud(self):
        os.system("echo . > sonarcloud")

    def Tensorflow(self):
        os.system("echo . > tensorflow")

    def Markdown(self):
        os.system("echo . > markdown")

def exit_handler():
    os.system("echo . > stopRStudio")
    os.system("echo . > stopSpyder")
    os.system("echo . > stopIBM")
    os.system("echo . > stopGit")
    os.system("echo . > stopJupyter")
    os.system("echo . > stopOrange")
    os.system("echo . > stopVSCode")
    os.system("echo . > stopHadoop")
    os.system("echo . > stopSpark")
    os.system("echo . > stopTableau")
    os.system("echo . > stopSonarCloud")
    os.system("echo . > stopTensorflow")
    os.system("echo . > stopMarkdown")

atexit.register(exit_handler)

root = tk.Tk()
app = Application(master=root)
app.mainloop()