----------------------------
freemarker					|
----------------------------
	# 模板本身也可以定义变量来使用。
	# 这些临时变量可以使用FTL指令来创建和替换
	# 模板级别定义的变量,在模板完成渲染后随即释放,并且存在同名属性时,渲染时优先使用模板变量
	# 如果变量名称包含特殊字符,可以用""包裹

	# 简单的变量
		* 它能从模板中的任何位置来访问,或者从使用 include 指令引入的模板访问(include 子模板也可以访问)
		* 可以使用 assign 指令来创建或覆盖这些变量,
		* 宏和方法也是变量,那么 macro 指令 和 function 指令 也可以用来设置变量,就像 assign 那样
			<#assign x = 1>
			<#assign x = x + 1>

	# 局部变量
		* 它们只能被设置在 宏定义体内, 而且只在宏内可见
		* 一个局部变量的生命周期只是宏的调用过程
		*  可以使用 local指令 在宏定义体内创建或替换局部变量
			<#macro foo>
				<#local y = 15>
			</#macro>

	# 循环变量
		* 循环变量是由如 list 指令自动创建的,而且它们只在指令的开始和结束标记内有效
		* 宏的参数是局部变量而不是循环变量

	# 全局变量
		* 这是一个高级话题了,并且这种变量最好别用
		* 即便它们属于不同的命名空间, 全局变量也被所有模板共享,因为它们是被 import进来的
		* 不同于 include 进来的,那么它们的可见度就像数据模型那样
		* 全局变量通过 global指令来定义
	

	

	# 越过局部变量,直接访问model变量,使用特殊变量 .globals
		<#assign user = "Joe Hider">
		${user}				Joe Hider
		${.globals.user}	KevinBlandy