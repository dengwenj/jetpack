### Jetpack
* jetpack 是个组件库，帮助我们更好的实现 mvvm 架构

### MVC
* View：Acitivity(View)、Fragment(View)视图，在android里xml布局转成View后，加载到了Activity/Fragment里了。
* Controller：Controller对应着Activity/Fragment，绑定UI，处理各种业务。
* Model：数据的获取，存储，更新，domain

### MVP
* View：Activity、Fragment
* Presenter：逻辑层
* Model：数据处理
* 优点：剥离了View和Controller，解决了复杂的业务Activity过于庞大的问题
* 缺点：更新UI需要主意线程，UI控件是否已经销毁(在用户可视的生命周期范围内更新UI即可)，假如我们去请求一个数据，这个时候请求是耗时的，数据回来了，可是界面已经被用户关掉了，数据回来以后，我们得判断UI控件是否还存在。 如果多个地方使用到同一个Presenter，可能会存在一些用不上的接口