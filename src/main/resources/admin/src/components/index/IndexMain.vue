<template>
	<div style="height: 100%;">
		<el-main :style='"vertical" == "vertical" ? (2 == 1 ? {"minHeight":"100%","padding":"0","margin":"0 0 0 210px","position":"relative","display":"block"} : (2 == 2 ? (isCollapse ? {"minHeight":"100%","padding":"0px 0 0 196px","margin":"0","position":"relative","background":"#EDEFFE","display":"block"} : {"minHeight":"100%","padding":"0","margin":"0 0 0 196px","position":"relative","background":"url(http://codegen.caihongy.cn/20250926/8a96fc4a924244adb7dab8606b837276.png) no-repeat center center / 100% 100%","display":"block"}) : "")) : {"minHeight":"100%","margin":"0","position":"relative"}'>
			<!-- top -->
			<index-header :style='{"padding":"0","boxShadow":" 0px 3px 10px 1px rgba(0,0,0,0.05)","margin":"0 30px 0 0","alignItems":"center","display":"flex","justifyContent":"flex-end","borderRadius":"0","flexWrap":"wrap","left":"0","background":"url(http://codegen.caihongy.cn/20251011/c356e555088a4ca79d7b0c9629fa843f.png) no-repeat center center  /  100% 100%","width":"100%","fontSize":"16px","position":"fixed","zIndex":"222","height":"85px"}'></index-header>
			
			<!-- menu -->
			<template v-if="'vertical' == 'vertical'">
			  <template v-if="2 == 1">
				<index-aside :style='{"boxShadow":"1px 0 6px  rgba(64, 158, 255, .3)","overflow":"hidden","top":"0","left":"0","background":"#304156","bottom":"0","width":"210px","fontSize":"0px","position":"fixed","height":"100%","zIndex":"1001"}'></index-aside>
			  </template>
			  <template v-if="2 == 2">
				<index-aside :is-collapse="isCollapse" @oncollapsechange="collapseChange" :style='isCollapse ? {"padding":"0px 20px 0 20px","overflow":"hidden","top":"85px","left":"0","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)","bottom":"0","width":"196px","position":"fixed","transition":"all 0s","height":"90%","zIndex":"1001"} : {"boxShadow":"0px 0 0px  #ddd","padding":"0px 20px 0 20px","overflow":"hidden","top":"85px","left":"0","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)","bottom":"0","width":"196px","position":"fixed","transition":"width 0.3s","height":"90%","zIndex":"1001"}'></index-aside>
			  </template>
			</template>
			<template v-if="'vertical' == 'horizontal'">
			  <template v-if="2 == 1">
				<index-aside :style='{"width":"100%","borderColor":"#efefef","borderStyle":"solid","background":"#304156","borderWidth":"0 0 1px 0","height":"auto"}'></index-aside>
			  </template>
			  <template v-if="2 == 2">
				<index-aside :style='{"borderColor":"#efefef","background":"#FFF","borderWidth":"0 0 1px 0","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}'></index-aside>
			  </template>
			</template>
			
			<!-- breadcrumb -->
			<bread-crumbs :title="title" :style='{"width":"100%","padding":"104px 10px 10px  20px ","margin":"0","borderRadius":"0px","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)"}' class="bread-crumbs"></bread-crumbs>
			
			<!-- TagsView -->
			<tags-view />
			<router-view class="router-view"></router-view>
		</el-main>
	</div>
</template>

<script>
	import IndexAside from '@/components/index/IndexAsideStatic'
	import IndexHeader from '@/components/index/IndexHeader'
	import TagsView from '@/components/index/TagsView'
	import menu from "@/utils/menu";
	export default {
		components: {
			IndexAside,
			IndexHeader,
			TagsView
		},
		data() {
			return {
				menuList: [],
				role: "",
				currentIndex: -2,
				itemMenu: [],
				title: '',
				isCollapse: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menuList = menus;
			this.role = this.$storage.get("role");
		},
		created() {
			this.init();
		},
		methods: {
			init(){
				this.$nextTick(()=>{
					
				})
			},
			collapseChange(collapse) {
				this.isCollapse = collapse
			},
			menuHandler(menu) {
				this.$router.push({
					name: menu.tableName
				});
				this.title = menu.menu;
			},
			titleChange(index, menus) {
				this.currentIndex = index
				this.itemMenu = menus;
			},
			homeChange(index) {
				this.itemMenu = [];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
			},
			centerChange(index) {
				this.itemMenu = [{
					"buttons": ["Add", "View", "Modify", "Delete"],
					"menu": "ChangePassword",
					"tableName": "updatePassword"
				}, {
					"buttons": ["Add", "View", "Modify", "Delete"],
					"menu": "Per information",
					"tableName": "center"
				}];
				this.title = ""
				this.currentIndex = index
				this.$router.push({
					name: 'home'
				});
				
			}
		}
	};
</script>
<style lang="scss" scoped>
	a {
		text-decoration: none;
		color: #555;
	}

	a:hover {
		background: #00c292;
	}
	
	.el-main {
		padding: 0;
		display: block;
	}

	.nav-list {
		width: 100%;
		margin: 0 auto;
		text-align: left;
		margin-top: 20px;

		.nav-title {
			display: inline-block;
			font-size: 15px;
			color: #333;
			padding: 15px 25px;
			border: none;
		}

		.nav-title.active {
			color: #555;
			cursor: default;
			background-color: #fff;
		}
	}

	.nav-item {
		margin-top: 20px;
		background: #FFFFFF;
		padding: 15px 0;

		.menu {
			padding: 15px 25px;
		}
	}
	
	.detail-form-content {
	    background: transparent;
	}
</style>
