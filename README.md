### Jetpack
* jetpack 是个组件库，帮助我们更好的实现 mvvm 架构
* 里面有各种各样写好的功能

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

### UI 驱动开发，数据驱动开发(监听数据变化，数据变了更新 UI)
### 以前是 presenter 层控制 UI 层。现在 UI 层监听 presenter 数据

### lifecycle 感知生命周期变化
* 1、主动获取状态，通过 owner 获取到 lifecycle，里面有当前的状态
* 2、通过 lifecycle 添加监听者，通过注解的方式，或者实现 LifecycleEventObserver 接口 

### LiveData

### ViewModel
* 中间，就是个逻辑类，和 presenter 层差不多，View 依赖与 ViewModel 的数据，ViewModel 依赖 Model
* ViewModel 类的主要优势实际上有两个方面：1、它允许您持久保留界面状态。 2、它可以提供对业务逻辑的访问权限。

### jetpack 与 mvvm
* ViewModel：对象为特定的界面组件（如 Fragment 或 Activity）提供数据，并包含数据处理业务逻辑，以及与 model 进行通信
* LiveData：是中可观察的数据存储器。应用中的其他组件可以使用此存储器监控对象的更改