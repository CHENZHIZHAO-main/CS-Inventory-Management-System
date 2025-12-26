<template>
	<div class="menu-preview">
		<!-- 竖向-2 -->
		<el-scrollbar :wrap-class="isCollapse ? 'scrollbar-wrapper scrollbar-wrapper-close' : 'scrollbar-wrapper scrollbar-wrapper-open'">
			<el-button :style="verticalStyle2[isCollapse?'close':'open'].btn.default" type="primary" @click="collapse">
				<span class="icon iconfont"
					:style="verticalStyle2[isCollapse?'close':'open'].btn.icon.default"
					:class="verticalStyle2[isCollapse?'close':'open'].btn.icon.text"></span>{{verticalStyle2[isCollapse?'close':'open'].btn.text}}
			</el-button>
			<div class="title" :style="verticalStyle2[isCollapse?'close':'open'].title.box.default">
				<el-image v-if="verticalStyle2[isCollapse?'close':'open'].title.img.flag" :style="verticalStyle2[isCollapse?'close':'open'].title.img.default" :src="topLogoUrl?($base.url + topLogoUrl):verticalStyle2[isCollapse?'close':'open'].title.img.url" fit="cover"></el-image>
				<span class="title-name" :style="verticalStyle2[isCollapse?'close':'open'].title.text.default">{{verticalStyle2[isCollapse?'close':'open'].title.text.showType?verticalStyle2[isCollapse?'close':'open'].title.text.text:''}} {{this.$project.projectName}}</span>
			</div>
			<div class="userinfo"
				:style="verticalStyle2[isCollapse?'close':'open'].userinfo.box.default">
				<el-image v-if="avatar" :style="verticalStyle2[isCollapse?'close':'open'].userinfo.img.default" :src="avatar?this.$base.url + avatar:require('@/assets/img/avator.png')" fit="cover"></el-image>
				<div :style="verticalStyle2[isCollapse?'close':'open'].userinfo.nickname.default">
				{{this.$storage.get('adminName')}}</div>
			</div>
			<el-menu :default-active="activeMenu" :unique-opened="true" :style="verticalStyle2[isCollapse?'close':'open'].menu.box.default"
				class="el-menu-vertical-2" :collapse-transition="false" :collapse="isCollapse">
				<el-menu-item class="home" :popper-append-to-body="false" popper-class="home" @click.native="menuHandler('')" :style="verticalStyle2[isCollapse?'close':'open'].home.one.box.default" index="/">
					<div class="el-tooltip">
						<i :style="verticalStyle2[isCollapse?'close':'open'].home.one.icon.default"
							class="icon iconfont icon-shouye-zhihui"></i>
							<span :style="verticalStyle2[isCollapse?'close':'open'].home.one.title.default"
							slot="title">{{verticalStyle2.open.home.one.title.text}}</span>
					</div>
				</el-menu-item>
				<el-submenu class="user" popper-class="user" :popper-append-to-body="false"
					:style="verticalStyle2[isCollapse?'close':'open'].user.one.box.default" index="1">
					<template slot="title">
						<i :style="verticalStyle2[isCollapse?'close':'open'].user.one.icon.default"
							class="icon iconfont icon-kuaijiezhifu"></i>
						<span :style="verticalStyle2[isCollapse?'close':'open'].user.one.title.default"
							slot="title">{{verticalStyle2.open.user.one.title.text}}</span>
					</template>
					<el-menu-item index="/updatePassword" @click="menuHandler('updatePassword')">ChangePassword</el-menu-item>
					<el-menu-item index="/center" @click="menuHandler('center')">Per information</el-menu-item>
				</el-submenu>
				<template v-for="(menu,index) in menuList.backMenu" v-if="menu.child.length&&menu.child[0].tableName!='hasBoard'&&menu.child[0].tableName!='storeup'&&(menu.child[0].tableName.length<=7||(menu.child[0].tableName.length>7&&menu.child[0].tableName.substring(0,7)!='chapter'))">
					<el-submenu v-if="menu.child.length > 1 || !verticalIsMultiple" class="other" popper-class="other" :popper-append-to-body="false" :style="verticalStyle2[isCollapse?'close':'open'].menu.one.box.default" :index="index+2+''">
						<template slot="title">
							<i :style="verticalStyle2[isCollapse?'close':'open'].menu.one.icon.default" class="el-icon-menu" :class="icons[index]"></i>
							<span :style="verticalStyle2[isCollapse?'close':'open'].menu.one.title.default" slot="title">{{menu.menu + (verticalFlag ? '管理' : '')}}</span>
						</template>
						<el-menu-item v-for="(child,sort) in menu.child" :key="sort" :index="'/'+child.tableName" @click="menuHandler(child.tableName)">{{ child.menu }}</el-menu-item>
					</el-submenu>
					<el-menu-item v-if="menu.child.length <= 1 && verticalIsMultiple" class="other" popper-class="other" :style="verticalStyle2[isCollapse?'close':'open'].menu.one.box.default" @click="menuHandler(menu.child[0].tableName)" :index="'/'+menu.child[0].tableName">
						<div class="el-tooltip">
							<i :style="verticalStyle2[isCollapse?'close':'open'].menu.one.icon.default" class="el-icon-menu" :class="icons[index]"></i>
							<span :style="verticalStyle2[isCollapse?'close':'open'].menu.one.title.default" slot="title">{{menu.child[0].menu + (verticalFlag ? '管理' : '')}}</span>
						</div>
					</el-menu-item>
				</template>
			</el-menu>
		</el-scrollbar>


	</div>
</template>

<script>
import menu from '@/utils/menu'
export default {
	data() {
		return {
			menuList: [],
			dynamicMenuRoutes: [],
			role: '',
			user: null,
			avatar:'',
			icons: [
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-fold',
				'el-icon-s-unfold',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-custom',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check',
				'el-icon-s-grid',
				'el-icon-menu',
				'el-icon-chat-dot-square',
				'el-icon-message',
				'el-icon-postcard',
				'el-icon-position',
				'el-icon-microphone',
				'el-icon-close-notification',
				'el-icon-bangzhu',
				'el-icon-time',
				'el-icon-odometer',
				'el-icon-crop',
				'el-icon-aim',
				'el-icon-switch-button',
				'el-icon-full-screen',
				'el-icon-copy-document',
				'el-icon-mic',
				'el-icon-stopwatch',
			],
			menulistBorderBottom: {},
			topLogoUrl: '',
			verticalFlag: false,
			isCollapse: false,
			verticalStyle2: {"isCollapse":false,"close":{"contentBox":{"hover":{},"active":{"margin":"0 0 0 54px"},"default":{"minHeight":"100%","padding":"0px 0 0 196px","margin":"0","position":"relative","background":"#EDEFFE","display":"block"}},"box":{"hover":{},"active":{"width":"54px"},"default":{"padding":"0px 20px 0 20px","overflow":"hidden","top":"85px","left":"0","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)","bottom":"0","width":"196px","position":"fixed","transition":"all 0s","height":"90%","zIndex":"1001"}},"title":{"img":{"hover":{},"default":{"width":"44px","objectFit":"cover","borderRadius":"100%","height":"44px"},"flag":true,"url":"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"},"box":{"hover":{},"default":{"width":"100%","padding":"20px","display":"none","height":"auto"}},"text":{"hover":{},"showType":true,"default":{"padding":"0 0 0 12px","lineHeight":"44px","fontSize":"12px","color":"rgba(64, 158, 255, 1)"},"text":"Welcome使用"}},"menu":{"two":{"title":{"hover":{"padding":"0 20px","lineHeight":"44px","color":"#fff !important","textAlign":"center","background":"#A4D348","height":"44px"},"active":{"padding":"0 20px","lineHeight":"44px","color":"#fff !important","textAlign":"center","background":"#A4D348","height":"44px"},"default":{"padding":"0 20px","backgroundColor":"#A4D348","borderColor":"#FFFFFF","color":"#FFFFFF!important","textAlign":"center","borderWidth":"0 0 1px 0","lineHeight":"44px","borderStyle":"solid","height":"44px"}},"box":{"hover":{},"default":{"border":"0px solid #FFFFFF","padding":"0","margin":"0 ","borderRadius":"8px","background":"none","borderWidth":"1px 1px 0"}}},"box":{"hover":{},"default":{"border":0,"minHeight":"100vh","padding":"0px 0 200px","listStyle":"none","margin":"0","flexWrap":"wrap","background":"linear-gradient( 180deg, #8091C0 0%, #455689 32%, #435487 61%, #85A1D5 100%)","flexDirection":"column","display":"flex","width":"100%","position":"relative"}},"one":{"box1":{"hover":{"color":"#A4D348","background":"none","backgroundImage":"none","transition":"all 0s"},"active":{"color":"#A4D348","background":"none","backgroundImage":"none","transition":"all 0s"},"default":{"cursor":"pointer","minHeight":"auto","padding":"30px 0","margin":"0 0 0 2px","color":"#fff","borderRadius":"14px","background":"none","width":"100%","position":"relative","transition":"all 0s","height":"auto"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 auto","color":"inherit","textAlign":"center","background":"url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%","display":"block","width":"60px","fontSize":"32px","lineHeight":"56px","height":"56px"},"flag":true},"box":{"hover":{},"default":{"padding":"0","listStyle":"none","margin":"0 0 0px","background":"none","height":"auto"}},"title":{"hover":{},"default":{"verticalAlign":"middle","color":"inherit","visibility":"visible","textAlign":"center","display":"block","width":"100%","fontSize":"16px","lineHeight":"2","height":"auto"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}},"btn":{"icon":{"hover":{},"default":{"margin":"0 2px","fontSize":"26px","color":"#ff7a00","height":"40px"},"text":"icon-menu02"},"hover":{"opacity":"0.8"},"default":{"border":"0","cursor":"pointer","padding":"0 9px","margin":"10px 0 10px 10px","outline":"none","color":"#ff7a00","borderRadius":"0","background":"rgba(64, 158, 255, 0)","display":"none","width":"auto","fontSize":"14px","height":"40px"},"text":""},"user":{"two":{"title":{"hover":{"padding":"0 20px","lineHeight":"44px","color":"#fff !important","background":"#A4D348","height":"44px"},"active":{"padding":"0 20px","lineHeight":"44px","color":"#fff !important","background":"#A4D348","height":"44px"},"default":{"padding":"0 20px","backgroundColor":"#A4D348","lineHeight":"44px","color":"#fff","height":"44px"}},"box":{"hover":{},"default":{"border":"0px solid #FFFFFF","padding":"0","margin":"0 ","borderRadius":"8px","background":"none","borderWidth":"1px 1px 0"}}},"one":{"box1":{"hover":{"color":"#A4D348","background":"none","backgroundImage":"none","transition":"all 0s"},"active":{"padding":"30px 0","margin":"0 0 0 10px","color":"#BD52EA","background":"none","backgroundImage":"none","transition":"all 0s"},"default":{"cursor":"pointer","minHeight":"auto","padding":"30px 0","margin":"0 0 0 2px","color":"#fff","borderRadius":"14px","background":"none","width":"100%","position":"relative","transition":"all 0s","height":"auto"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 auto","color":"inherit","textAlign":"center","background":"url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%","display":"block","width":"60px","fontSize":"32px"},"flag":true,"text":"icon-kuaijiezhifu"},"box":{"hover":{},"default":{"padding":"0","listStyle":"none","margin":"0 0 -30px","background":"none","height":"auto","order":"22"}},"title":{"hover":{},"default":{"verticalAlign":"middle","color":"inherit","visibility":"visible","textAlign":"center","display":"block","width":"100%","fontSize":"16px","lineHeight":"2","height":"auto"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}},"userinfo":{"nickname":{"hover":{},"default":{"fontSize":"24px","lineHeight":"1.5","color":"#fff","textAlign":"center"}},"img":{"hover":{},"default":{"width":"100%","objectFit":"cover","borderRadius":"20px","display":"block","height":"170px"}},"box":{"hover":{},"default":{"width":"100%","padding":"20px","display":"none","height":"auto"}}},"home":{"two":{"title":{"hover":{"padding":"0 20px","backgroundColor":"red !important","lineHeight":"56px","color":"#fff","height":"56px"},"active":{"padding":"0 20px","backgroundColor":"blue !important","lineHeight":"56px","color":"#fff","height":"56px"},"default":{"padding":"0 20px","backgroundColor":"#fff","lineHeight":"56px","color":"#646","height":"56px"}},"box":{"hover":{},"default":{"border":"none"}}},"one":{"box1":{"hover":{"color":"#BD52EA","background":"none","backgroundImage":"none","transition":"all 0s"},"active":{"color":"#BD52EA","background":"none","backgroundImage":"none","transition":"all 0s"},"default":{"cursor":"pointer","minHeight":"auto","padding":"30px 0","margin":"0 0 0 2px","color":"#fff","borderRadius":"14px","background":"none","width":"100%","position":"relative","transition":"all 0s","height":"auto"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 auto","color":"inherit","textAlign":"center","background":"url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%","display":"block","width":"60px","fontSize":"32px"},"flag":true,"text":"icon-shouye-zhihui"},"box":{"hover":{},"default":{"padding":"0","listStyle":"none","margin":"0 0 -30px","background":"none","backgroundImage":"none","height":"auto"}},"title":{"hover":{},"default":{"verticalAlign":"middle","color":"inherit","visibility":"visible","textAlign":"center","display":"block","width":"100%","fontSize":"16px","lineHeight":"2","height":"auto"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}}},"open":{"contentBox":{"hover":{},"default":{"minHeight":"100%","padding":"0","margin":"0 0 0 196px","position":"relative","background":"url(http://codegen.caihongy.cn/20250926/8a96fc4a924244adb7dab8606b837276.png) no-repeat center center / 100% 100%","display":"block"}},"box":{"hover":{},"default":{"boxShadow":"0px 0 0px  #ddd","padding":"0px 20px 0 20px","overflow":"hidden","top":"85px","left":"0","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)","bottom":"0","width":"196px","position":"fixed","transition":"width 0.3s","height":"90%","zIndex":"1001"}},"title":{"img":{"hover":{},"default":{"width":"44px","objectFit":"cover","borderRadius":"100%","height":"44px"},"flag":false,"url":"http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"},"box":{"hover":{},"default":{"width":"100%","padding":"20px","display":"none","height":"auto"}},"text":{"hover":{},"showType":true,"default":{"padding":"0 0 0 12px","lineHeight":"44px","fontSize":"12px","color":"rgba(64, 158, 255, 1)"},"text":"Welcome使用"}},"menu":{"two":{"title":{"hover":{"padding":"0","lineHeight":"42px","color":"#405a9a !important","textAlign":"center","background":"#A4D348","height":"42px"},"active":{"padding":"0","color":"#405a9a !important","borderRadius":"0","textAlign":"center","background":"#A4D348"},"default":{"padding":"0","color":"#fff","textAlign":"center","background":"none","lineHeight":"42px","fontSize":"16px","minWidth":"100%","height":"42px"}},"box":{"hover":{},"default":{"border":"none","padding":"10px 0","margin":"5px auto 0","borderColor":"#e5e5e5","borderRadius":"10px","background":"#A4D348","borderWidth":"0","width":"80%","borderStyle":"solid"}}},"box":{"hover":{},"default":{"border":0,"padding":"20px 0 200px","margin":"0 0 0 0","borderColor":"#cecece","alignItems":"flex-start","display":"flex","alignContent":"flex-start","minHeight":"100vh","listStyle":"none","flexWrap":"wrap","borderWidth":"1px 0 0 0 ","background":"linear-gradient( 180deg, #8091C0 0%, #455689 32%, #435487 61%, #85A1D5 100%)","width":"100%","position":"relative","borderStyle":"solid","zIndex":"1","height":"auto"}},"one":{"box1":{"hover":{"color":"#A4D348","borderRadius":"0","background":"none"},"active":{"color":"#A4D348","borderRadius":"0"},"default":{"cursor":"pointer","padding":"0","margin":"0","whiteSpace":"nowrap","color":"#fff","textAlign":"center","background":"none","width":"100%","lineHeight":"1.5","position":"relative","height":"auto"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 auto","color":"inherit","textAlign":"center","background":"url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%","display":"block","width":"60px","fontSize":"32px","lineHeight":"56px","height":"56px"},"flag":true},"box":{"hover":{},"default":{"width":"100%","padding":"0","listStyle":"none","margin":"0 0 20px","height":"auto"}},"title":{"hover":{},"default":{"color":"inherit","verticalAlign":"middle","fontSize":"16px"}},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}},"btn":{"icon":{"hover":{},"default":{"margin":"0 2px","fontSize":"26px","color":"#ff7a00","height":"40px"},"text":"icon-menu02"},"hover":{"opacity":"0.8"},"default":{"border":"0","cursor":"pointer","padding":"0 9px","outline":"none","margin":"10px 0 10px 10px","color":"#ff7a00","borderRadius":"4px","background":"rgba(64, 158, 255, 0)","display":"none","width":"auto","fontSize":"14px","height":"40px"},"text":""},"user":{"two":{"title":{"hover":{"padding":"0","lineHeight":"42px","color":"#405a9a !important","textAlign":"center","background":"#A4D348","height":"42px"},"active":{"padding":"0","lineHeight":"42px","color":"#405a9a !important","textAlign":"center","background":"#A4D348","height":"42px"},"default":{"padding":"0","color":"#fff","textAlign":"center","background":"none","lineHeight":"42px","fontSize":"16px","minWidth":"100%","height":"42px"}},"box":{"hover":{},"default":{"border":"none","padding":"10px 0","margin":"5px auto 0","borderColor":"#e5e5e5","borderRadius":"10px","background":"#A4D348","borderWidth":"0","width":"80%","borderStyle":"solid"}}},"one":{"box1":{"hover":{"color":"#A4D348","borderRadius":"0","background":"none"},"active":{"color":"#A4D348","borderRadius":"0","background":"none"},"default":{"cursor":"pointer","padding":"0","margin":"0","whiteSpace":"nowrap","color":"#fff","textAlign":"center","background":"none","width":"100%","lineHeight":"auto","position":"relative","height":"auto"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 auto","color":"inherit","textAlign":"center","background":"url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%","display":"block","width":"60px","fontSize":"32px","lineHeight":"56px","height":"56px"},"flag":true,"text":"icon-kuaijiezhifu"},"box":{"hover":{},"default":{"width":"100%","padding":"0","listStyle":"none","margin":"0 0 20px","borderRadius":"4px","order":"22"}},"title":{"hover":{},"default":{"verticalAlign":"middle","fontSize":"16px","lineHeight":"1.5","color":"inherit"},"text":"User Centre"},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","display":"none","fontSize":"12px","position":"absolute","right":"20px"}}}},"userinfo":{"nickname":{"hover":{},"default":{"fontSize":"18px","lineHeight":"2","color":"#fff","textAlign":"center"}},"img":{"hover":{},"default":{"width":"80px","margin":"0 auto","objectFit":"cover","borderRadius":"100%","display":"block","height":"80px"}},"box":{"hover":{},"default":{"width":"100%","padding":"40px","textAlign":"center","background":"#095dac","display":"none","height":"auto"}}},"home":{"two":{"title":{"hover":{"padding":"0 40px","margin":"0 16px","lineHeight":"40px","color":"#fff","height":"40px"},"active":{"padding":"0 40px","margin":"0 16px","lineHeight":"40px","color":"#fff","background":"#8B2121","height":"40px"},"default":{"padding":"0 40px","lineHeight":"40px","color":"#664","background":"#fff","height":"40px"}},"box":{"hover":{},"default":{"border":"none","display":"none"}}},"one":{"box1":{"hover":{"borderRadius":"0","color":"#A4D348"},"active":{"borderRadius":"0","color":"#A4D348"},"default":{"cursor":"pointer","padding":"0","margin":"0","whiteSpace":"nowrap","color":"#fff","textAlign":"center","background":"none","width":"100%","lineHeight":"1.5","position":"relative","height":"auto"}},"icon":{"hover":{},"default":{"verticalAlign":"middle","margin":"0 auto","color":"inherit","textAlign":"center","background":"url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%","display":"block","width":"60px","fontSize":"32px","lineHeight":"56px","height":"56px"},"flag":true,"text":"icon-shouye-zhihui"},"box":{"hover":{},"default":{"width":"100%","padding":"0","listStyle":"none","margin":"0 0 20px","height":"auto"}},"title":{"hover":{},"default":{"verticalAlign":"middle","fontSize":"16px","lineHeight":"1.5","color":"inherit"},"text":"Homepage"},"arrow":{"hover":{},"default":{"verticalAlign":"middle","margin":"-7px 0 0 0","top":"50%","color":"inherit","fontSize":"12px","position":"absolute","right":"20px"}}}}}},
			verticalIsMultiple: true,
		}
	},
	computed: {
		activeMenu() {
			const route = this.$route
			const {
				meta,
				path
			} = route
			// if st path, the sidebar will highlight the path you sete
			if (meta.activeMenu) {
				return meta.activeMenu
			}
			return path
		}
	},
	watch:{
		avatar(){
			this.$forceUpdate()
		},
	},
	mounted() {
		let menus = menu.list()
			if(menus) {
				let arr = []
				let brr = []
				menus.forEach(item=>{
					if(item.roleName == this.$storage.get('role')) {
  					item.backMenu.forEach(item1=>{
						if(item1.menu == 'Equip Information管理') {
							if(
										this.isAuth('shebeixinxi','Inventory Statistics')
							) {
								arr.push({
									allButtons: ['View'],
									buttons: ['View'],
									menu: 'Equip Statistics',
									tableName: 'shebeixinxistat',
								})
							}
						}
					})
  					item.backMenu.forEach(item1=>{
						if(item1.menu == 'Lend equipment管理') {
							if(
										this.isAuth('jiechushebei','Borrow Statistics')
							) {
								arr.push({
									allButtons: ['View'],
									buttons: ['View'],
									menu: 'Equip Statistics',
									tableName: 'jiechushebeistat',
								})
							}
						}
					})
				}
			})
			if(arr.length) {
				let crr = {
					menu: 'Statistical Manage',
					child: arr
				}
				menus.forEach(item=>{
					if(item.roleName == this.$storage.get('role')) {
						item.backMenu.splice(0,0,crr)
					}
				})
			}
			
			this.menuList = menus
		} else {
			let params = {
				page: 1,
				limit: 1,
				sort: 'id',
			}
			
			this.$http({
				url: "menu/list",
				method: "get",
				params: params
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					let arr = []
					let brr = []
					menus = JSON.parse(data.data.list[0].menujson)
					menus.forEach(item=>{
						if(item.roleName == this.$storage.get('role')) {
  							item.backMenu.forEach(item1=>{
								if(item1.menu == 'Equip Information管理') {
									if(
										this.isAuth('shebeixinxi','Inventory Statistics')
									) {
										arr.push({
											allButtons: ['View'],
											buttons: ['View'],
											menu: 'Equip Statistics',
											tableName: 'shebeixinxistat',
										})
									}
								}
							})
  							item.backMenu.forEach(item1=>{
								if(item1.menu == 'Lend equipment管理') {
									if(
										this.isAuth('jiechushebei','Borrow Statistics')
									) {
										arr.push({
											allButtons: ['View'],
											buttons: ['View'],
											menu: 'Equip Statistics',
											tableName: 'jiechushebeistat',
										})
									}
								}
							})
						}
					})
					if(arr.length) {
						let crr = {
							menu: 'Statistical Manage',
							child: arr
						}
						menus.forEach(item=>{
							if(item.roleName == this.$storage.get('role')) {
								item.backMenu.splice(0,0,crr)
							}
						})
					}
					this.menuList = menus;
					this.$storage.set("menus", this.menuList);
				}
			})
		}
		this.role = this.$storage.get('role')
		
		for(let i=0;i<this.menuList.length;i++) {
			if(this.menuList[i].roleName == this.role) {
				this.menuList = this.menuList[i];
				break;
			}
		}
		this.styleChange()
		
		let sessionTable = this.$storage.get("sessionTable")
		this.$http({
			url: sessionTable + '/session',
			method: "get"
		}).then(({
			data
		}) => {
			if (data && data.code === 0) {
				if(sessionTable == 'renyuan') {
					this.avatar = data.data.touxiang
				}
				if(sessionTable=='users') {
					this.avatar = data.data.image
				}
				this.user = data.data;
			} else {
				let message = this.$message
				message.error(data.msg);
			}
		});
	},
	created(){
		this.icons.sort(()=>{
			return (0.5-Math.random())
		})
	},
	methods: {
		collapse() {
		  this.isCollapse = !this.isCollapse
		  this.$emit('oncollapsechange', this.isCollapse)
		},
		styleChange() {
			this.$nextTick(() => {
								document.querySelectorAll('.el-menu-vertical-demo .el-submenu .el-menu').forEach(el => {
				  el.removeAttribute('style')
				  const icon = {"border":"none","display":"none"}
				  Object.keys(icon).forEach((key) => {
					el.style[key] = icon[key]
				  })
				})
											})
		},
		menuHandler(name) {
			let router = this.$router
			name = '/'+name
			router.push(name)
		},
	}
}
</script>
<style lang="scss" scoped>
	.menu-preview {
		.el-scrollbar {
			height: 100%;
	
			& /deep/ .scrollbar-wrapper {
				overflow-x: hidden;
			}
		
			// 竖向
			.el-menu-vertical-demo {
				.el-submenu:first-of-type /deep/ .el-submenu__title .el-submenu__icon-arrow {
					display: none;
				}
			}
			
			.el-menu-vertical-demo>.el-menu-item {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				position: relative;
			}
			
			.el-menu-vertical-demo>.el-menu-item:hover {
				color: #fff;
				background: blue;
			}
			
			.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title {
				cursor: pointer;
				padding: 0 20px;
				color: #333;
				white-space: nowrap;
				background: #fff;
				position: relative;
			}
			
			.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title:hover {
				color: #fff;
				background: blue;
			}
			
			.el-menu-vertical-demo .el-submenu /deep/ .el-submenu__title .el-submenu__icon-arrow {
				margin: -7px 0 0 0;
				top: 50%;
				color: inherit;
				vertical-align: middle;
				font-size: 12px;
				position: absolute;
				right: 20px;
			}
			
			.el-menu-vertical-demo .el-submenu {
				padding: 0;
				margin: 0;
				list-style: none;
			}
			
			// .el-menu-vertical-demo .el-submenu /deep/ .el-menu {
// 					// 		border: none;
// 					// 		display: none;
// 					// }
			
			.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item {
				padding: 0 40px;
				color: #666;
				background: #fff;
				line-height: 50px;
				height: 50px;
			}
			
			.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item:hover {
				padding: 0 40px;
				color: #fff;
				background: red;
				line-height: 50px;
				height: 50px;
			}
			
			.el-menu-vertical-demo .el-submenu /deep/ .el-menu .el-menu-item.is-active {
				padding: 0 40px;
				color: #fff;
				background: blue;
				line-height: 50px;
				height: 50px;
			}
			// 竖向
		}
	}
	// 竖向 样式二-open
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other {
		font-size: inherit;
		background: none;
	}
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home {
		font-size: inherit;
		background: none;
	}
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other>.el-tooltip {
		cursor: pointer;
		padding: 0;
		margin: 0;
		color: #fff;
		white-space: nowrap;
		background: none;
		width: 100%;
		line-height: 1.5;
		position: relative;
		text-align: center;
		height: auto;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other>.el-tooltip:hover {
		border-radius: 0 !important;
		color: #A4D348 !important;
		background: none !important;
	}
	
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title {
		cursor: pointer !important;
		padding: 0 !important;
		margin: 0 !important;
		color: #fff !important;
		white-space: nowrap !important;
		background: none !important;
		width: 100% !important;
		line-height: 1.5 !important;
		position: relative !important;
		text-align: center !important;
		height: auto !important;
	}
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.other.is-active>.el-tooltip {
		border-radius: 0 !important;
		color: #A4D348 !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title:hover {
		border-radius: 0 !important;
		color: #A4D348 !important;
		background: none !important;
	}
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other.is-active /deep/ .el-submenu__title {
		border-radius: 0 !important;
		color: #A4D348 !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .iconfont {
		margin: 0 auto;
		color: inherit;
		background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%;
		display: block;
		vertical-align: middle;
		width: 60px;
		font-size: 32px;
		line-height: 56px;
		text-align: center;
		height: 56px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .el-submenu__icon-arrow {
		margin: -7px 0 0 0;
		top: 50%;
		color: inherit;
		display: none;
		vertical-align: middle;
		font-size: 12px;
		position: absolute;
		right: 20px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 /deep/ .el-submenu.other .el-menu {
		border: none;
		border-radius: 10px;
		padding: 10px 0;
		margin: 5px auto 0;
		background: #A4D348;
		width: 80%;
		border-color: #e5e5e5;
		border-width: 0;
		border-style: solid;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other .el-menu .el-menu-item {
		padding: 0 !important;
		color: #fff !important;
		background: none !important;
		font-size: 16px !important;
		line-height: 42px !important;
		text-align: center !important;
		min-width: 100% !important;
		height: 42px !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other .el-menu .el-menu-item:hover {
		padding: 0 !important;
		color: #405a9a !important !important;
		background: #A4D348 !important;
		line-height: 42px !important;
		text-align: center !important;
		height: 42px !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.other .el-menu .el-menu-item.is-active {
		border-radius: 0 !important;
		padding: 0 !important;
		color: #405a9a !important !important;
		background: #A4D348 !important;
		text-align: center !important;
	}

	// 竖向 样式二-close
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.other>.el-tooltip {
		cursor: pointer;
		border-radius: 14px;
		padding: 30px 0;
		margin: 0 0 0 2px;
		color: #fff;
		background: none;
		width: 100%;
		min-height: auto;
		position: relative;
		transition: all 0s;
		height: auto;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.other>.el-tooltip:hover {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.other.is-active>.el-tooltip {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title {
		cursor: pointer !important;
		border-radius: 14px !important;
		padding: 30px 0 !important;
		margin: 0 0 0 2px !important;
		color: #fff !important;
		background: none !important;
		width: 100% !important;
		min-height: auto !important;
		position: relative !important;
		transition: all 0s !important;
		height: auto !important;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title:hover {
		color: #A4D348 !important;
		background: none !important;
		background-image: none !important;
		transition: all 0s !important;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .iconfont {
		margin: 0 auto;
		color: inherit;
		background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%;
		display: block;
		vertical-align: middle;
		width: 60px;
		font-size: 32px;
		line-height: 56px;
		text-align: center;
		height: 56px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other /deep/ .el-submenu__title .el-submenu__icon-arrow {
		margin: -7px 0 0 0;
		top: 50%;
		color: inherit;
		display: none;
		vertical-align: middle;
		font-size: 12px;
		position: absolute;
		right: 20px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu {
		border: 0px solid #FFFFFF;
		border-radius: 8px;
		padding: 0;
		margin: 0 ;
		background: none;
		border-width: 1px 1px 0;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu--vertical.other .el-menu-item {
		background-color: #A4D348;
		padding: 0 20px;
		color: #FFFFFF!important;
		border-color: #FFFFFF;
		border-width: 0 0 1px 0;
		line-height: 44px;
		border-style: solid;
		text-align: center;
		height: 44px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu--vertical.other .el-menu-item:hover {
		padding: 0 20px;
		color: #fff !important;
		background: #A4D348;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.other .el-menu--vertical.other .el-menu-item.is-active {
		padding: 0 20px;
		color: #fff !important;
		background: #A4D348;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
	
	// 竖向 样式二-open-Homepage
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home>.el-tooltip {
		cursor: pointer;
		padding: 0;
		margin: 0;
		color: #fff;
		white-space: nowrap;
		background: none;
		width: 100%;
		line-height: 1.5;
		position: relative;
		text-align: center;
		height: auto;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home>.el-tooltip:hover {
		border-radius: 0;
		color: #A4D348;
		background: none;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.home.is-active>.el-tooltip {
		border-radius: 0;
		color: #A4D348;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title {
		cursor: pointer !important;
		padding: 0 !important;
		margin: 0 !important;
		color: #fff !important;
		white-space: nowrap !important;
		background: none !important;
		width: 100% !important;
		line-height: 1.5 !important;
		position: relative !important;
		text-align: center !important;
		height: auto !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title:hover {
		border-radius: 0 !important;
		color: #A4D348 !important;
		background: none !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .iconfont {
		margin: 0 auto;
		color: inherit;
		background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%;
		display: block;
		vertical-align: middle;
		width: 60px;
		font-size: 32px;
		line-height: 56px;
		text-align: center;
		height: 56px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .el-submenu__icon-arrow {
		margin: -7px 0 0 0;
		top: 50%;
		color: inherit;
		display: none;
		vertical-align: middle;
		font-size: 12px;
		position: absolute;
		right: 20px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu {
		border: none;
		border-radius: 10px;
		padding: 10px 0;
		margin: 5px auto 0;
		background: #A4D348;
		width: 80%;
		border-color: #e5e5e5;
		border-width: 0;
		border-style: solid;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu .el-menu-item {
		padding: 0;
		color: #fff;
		background: none;
		font-size: 16px;
		line-height: 42px;
		text-align: center;
		min-width: 100%;
		height: 42px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu .el-menu-item:hover {
		padding: 0;
		color: #405a9a !important;
		background: #A4D348;
		line-height: 42px;
		text-align: center;
		height: 42px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.home .el-menu .el-menu-item.is-active {
		border-radius: 0;
		padding: 0;
		color: #405a9a !important;
		background: #A4D348;
		text-align: center;
	}
	
	// 竖向 样式二-close-Homepage
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.home>.el-tooltip {
		cursor: pointer;
		border-radius: 14px;
		padding: 30px 0;
		margin: 0 0 0 2px;
		color: #fff;
		background: none;
		width: 100%;
		min-height: auto;
		position: relative;
		transition: all 0s;
		height: auto;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.home>.el-tooltip:hover {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.home.is-active>.el-tooltip {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title {
		cursor: pointer;
		border-radius: 14px;
		padding: 30px 0;
		margin: 0 0 0 2px;
		color: #fff;
		background: none;
		width: 100%;
		min-height: auto;
		position: relative;
		transition: all 0s;
		height: auto;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title:hover {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .iconfont {
		margin: 0 auto;
		color: inherit;
		background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%;
		display: block;
		vertical-align: middle;
		width: 60px;
		font-size: 32px;
		line-height: 56px;
		text-align: center;
		height: 56px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home /deep/ .el-submenu__title .el-submenu__icon-arrow {
		margin: -7px 0 0 0;
		top: 50%;
		color: inherit;
		display: none;
		vertical-align: middle;
		font-size: 12px;
		position: absolute;
		right: 20px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu {
		border: 0px solid #FFFFFF;
		border-radius: 8px;
		padding: 0;
		margin: 0 ;
		background: none;
		border-width: 1px 1px 0;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu--vertical.home .el-menu-item {
		background-color: #A4D348;
		padding: 0 20px;
		color: #FFFFFF!important;
		border-color: #FFFFFF;
		border-width: 0 0 1px 0;
		line-height: 44px;
		border-style: solid;
		text-align: center;
		height: 44px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu--vertical.home .el-menu-item:hover {
		padding: 0 20px;
		color: #fff !important;
		background: #A4D348;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.home .el-menu--vertical.home .el-menu-item.is-active {
		padding: 0 20px;
		color: #fff !important;
		background: #A4D348;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
	
	// 竖向 样式二-open-Personal Centre
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.user>.el-tooltip {
		cursor: pointer;
		padding: 0;
		margin: 0;
		color: #fff;
		white-space: nowrap;
		background: none;
		width: 100%;
		line-height: 1.5;
		position: relative;
		text-align: center;
		height: auto;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.user>.el-tooltip:hover {
		border-radius: 0;
		color: #A4D348;
		background: none;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2>.el-menu-item.user.is-active>.el-tooltip {
		border-radius: 0;
		color: #A4D348;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title {
		cursor: pointer !important;
		padding: 0 !important;
		margin: 0 !important;
		color: #fff !important;
		white-space: nowrap !important;
		background: none !important;
		width: 100% !important;
		line-height: 1.5 !important;
		position: relative !important;
		text-align: center !important;
		height: auto !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title:hover {
		border-radius: 0 !important;
		color: #A4D348 !important;
		background: none !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .iconfont {
		margin: 0 auto;
		color: inherit;
		background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%;
		display: block;
		vertical-align: middle;
		width: 60px;
		font-size: 32px;
		line-height: 56px;
		text-align: center;
		height: 56px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .el-submenu__icon-arrow {
		margin: -7px 0 0 0;
		top: 50%;
		color: inherit;
		display: none;
		vertical-align: middle;
		font-size: 12px;
		position: absolute;
		right: 20px;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 /deep/ .el-submenu.user .el-menu {
		border: none;
		border-radius: 10px;
		padding: 10px 0;
		margin: 5px auto 0;
		background: #A4D348;
		width: 80%;
		border-color: #e5e5e5;
		border-width: 0;
		border-style: solid;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user .el-menu .el-menu-item {
		padding: 0 !important;
		color: #fff !important;
		background: none !important;
		font-size: 16px !important;
		line-height: 42px !important;
		text-align: center !important;
		min-width: 100% !important;
		height: 42px !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user .el-menu .el-menu-item:hover {
		padding: 0 !important;
		color: #405a9a !important !important;
		background: #A4D348 !important;
		line-height: 42px !important;
		text-align: center !important;
		height: 42px !important;
	}
	
	.scrollbar-wrapper-open .el-menu-vertical-2 .el-submenu.user .el-menu .el-menu-item.is-active {
		border-radius: 0 !important;
		padding: 0 !important;
		color: #405a9a !important !important;
		background: #A4D348 !important;
		text-align: center !important;
	}
	
	// 竖向 样式二-close-Personal Centre
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.user>.el-tooltip {
		cursor: pointer;
		border-radius: 14px;
		padding: 30px 0;
		margin: 0 0 0 2px;
		color: #fff;
		background: none;
		width: 100%;
		min-height: auto;
		position: relative;
		transition: all 0s;
		height: auto;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.user>.el-tooltip:hover {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2>.el-menu-item.user.is-active>.el-tooltip {
		color: #A4D348;
		background: none;
		background-image: none;
		transition: all 0s;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title {
		cursor: pointer !important;
		border-radius: 14px !important;
		padding: 30px 0 !important;
		margin: 0 0 0 2px !important;
		color: #fff !important;
		background: none !important;
		width: 100% !important;
		min-height: auto !important;
		position: relative !important;
		transition: all 0s !important;
		height: auto !important;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title:hover {
		color: #A4D348 !important;
		background: none !important;
		background-image: none !important;
		transition: all 0s !important;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .iconfont {
		margin: 0 auto;
		color: inherit;
		background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat center center / 100% 100%;
		display: block;
		vertical-align: middle;
		width: 60px;
		font-size: 32px;
		line-height: 56px;
		text-align: center;
		height: 56px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user /deep/ .el-submenu__title .el-submenu__icon-arrow {
		margin: -7px 0 0 0;
		top: 50%;
		color: inherit;
		display: none;
		vertical-align: middle;
		font-size: 12px;
		position: absolute;
		right: 20px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu {
		border: 0px solid #FFFFFF;
		border-radius: 8px;
		padding: 0;
		margin: 0 ;
		background: none;
		border-width: 1px 1px 0;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu--vertical.user .el-menu-item {
		background-color: #A4D348;
		padding: 0 20px;
		color: #FFFFFF!important;
		border-color: #FFFFFF;
		border-width: 0 0 1px 0;
		line-height: 44px;
		border-style: solid;
		text-align: center;
		height: 44px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu--vertical.user .el-menu-item:hover {
		padding: 0 20px;
		color: #fff !important;
		background: #A4D348;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
	
	.scrollbar-wrapper-close .el-menu-vertical-2 .el-submenu.user .el-menu--vertical.user .el-menu-item.is-active {
		padding: 0 20px;
		color: #fff !important;
		background: #A4D348;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
</style>
