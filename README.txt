Cisco TDD DOJO User Story
--------------------------------------------------------------------------------
1. 作为贷款人，我希望能够输入贷款总额、选择还款方式和按揭年数后可以查看每月还款额和还款总额以便我做贷款决策
2. 作为贷款人，我希望可以选择商业贷款、公积金贷款和混合型贷款计算每月还款额和还款总额以便我做贷款决策
3. 作为贷款人，我希望可以根据面积、单价和按揭成数来计算每月还款额和还款总额以便我做贷款决策
4. 作为贷款人，我希望可以根据历史基准利率及折扣来计算每月还款额和还款总额以便我做贷款决策

Web版购房贷款计算器
http://soufun.com/house/newhouse/newhouse_tools.aspx

实现要求：
1. 开发全程需应用验收测试驱动开发和测试驱动开发
2. 购房贷款计算器要求使用Swing实现
3. 公积金和商业贷款的历史基准利率由WebService提供，部署在tomcat上


Environment Setup
--------------------------------------------------------------------------------
1. 虚拟机软件：VirtualBox
   https://www.virtualbox.org/wiki/Downloads
   虚拟机文件培训当天使用U盘拷贝
2. 开发环境：Ubuntu Linux/Eclipse


Assumption
--------------------------------------------------------------------------------
1. 每对学员有基础开发和自动化测试的经验
2. 每对学员对重构/结对编程/持续集成有一些了解
3. 每对学员熟悉Swing开发并对JUnit/WebService有一定了解
4. 每对学员熟悉Eclipse/Maven并对Jenkins/Tomcat有一定了解


Lab Preparation
--------------------------------------------------------------------------------
1. 代码道场
   http://codingdojo.org/cgi-bin/wiki.pl?FrontPage 
   http://www.danielteng.com/2011/03/15/coding-doj/

2. 结对编程
   http://en.wikipedia.org/wiki/Pair_programming
   http://zh.wikipedia.org/wiki/%E7%BB%93%E5%AF%B9%E7%BC%96%E7%A8%8B

3. 还款方式
   等额本金：http://baike.baidu.com/view/1274152.htm
   等额本息：http://baike.baidu.com/view/178589.htm

4. 模拟对象库：EasyMock
   http://www.easymock.org/EasyMock3_1_Documentation.html
   
5. 验收测试驱动开发工具：WindowLicker
   https://code.google.com/p/windowlicker/
   
6. WebService库：Axis2
   http://axis.apache.org/axis2/java/core/

