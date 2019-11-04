# 代码规范手册

尊敬的各位开发者：

&emsp;&emsp;您好！欢迎成为 [Dragon1573/Revision-3A](https://github.com/Dragon1573/Revision-3A) 的一名贡献者。我是 [@Dragon1573](https://github.com/Dragon1573) ，欢迎你们！

&emsp;&emsp;在您打算帮助我维护存储库之前，我有义务提醒您：请严格遵守以下代码规范书写您的代码。对于为严格按照本规范编码的开发者，您发起的 Pull Request 很有可能会被我忽略并关闭。

## 代码风格

&emsp;&emsp;本项目中的所有Python脚本需严格遵守 [Python PEP8](https://www.python.org/dev/peps/pep-0008/) 代码风格规范。但请注意：**由于JupyterLab与Jupyter Notebook提供了Soft Warp代码自动换行功能，PEP8代码风格规范中“最大行长度为79字符”规则作废，单行长度不予限制**。

&emsp;&emsp;您可以通过安装以下工具对代码执行快速格式化。

1. `AutoPEP8`代码格式化工具
    ```shell
    # 使用 pip 包管理工具安装
    python -m pip install autopep8
    
    # 使用 conda 包管理工具安装
    python -m conda install autopep8
    ```


2. `Flake8`代码格式化工具
    ```shell
    # 使用 pip 包管理工具安装
    python -m pip install flake8
    
    # 使用 conda 包管理工具安装
    python -m conda install flake8
    ```
