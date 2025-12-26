import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import renyuan from '@/views/modules/renyuan/list'
	import shebeifenlei from '@/views/modules/shebeifenlei/list'
	import shebeixinxi from '@/views/modules/shebeixinxi/list'
	import jiechushebei from '@/views/modules/jiechushebei/list'
	import yuqitixing from '@/views/modules/yuqitixing/list'
	import guihaishebei from '@/views/modules/guihaishebei/list'
	import syslog from '@/views/modules/syslog/list'
	import users from '@/views/modules/users/list'
import config from '@/views/modules/config/list'

//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: ' System Homepage',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: ' System Homepage',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: 'ChangePassword',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: 'Per information',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/renyuan',
		name: 'Student/Teacher',
		component: renyuan
	}
	,{
		path: '/shebeifenlei',
		name: 'E-Type',
		component: shebeifenlei
	}
	,{
		path: '/shebeixinxi',
		name: 'Equip Information',
		component: shebeixinxi
	}
	,{
		path: '/shebeixinxistat',
		name: 'Equip Statistics',
		component: shebeixinxi
	}
	,{
		path: '/jiechushebei',
		name: 'Lend equipment',
		component: jiechushebei
	}
	,{
		path: '/jiechushebeistat',
		name: 'Equip Statistics',
		component: jiechushebei
	}
	,{
		path: '/yuqitixing',
		name: 'Overdue Reminder',
		component: yuqitixing
	}
	,{
		path: '/guihaishebei',
		name: 'Return equipment',
		component: guihaishebei
	}
	,{
		path: '/syslog',
		name: ' System log',
		component: syslog
	}
	,{
		path: '/users',
		name: 'admin',
		component: users
	}
	,{
		path: '/config/:type',
		name: '配置管理',
		component: config
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//Modify原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;
