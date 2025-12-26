<template>
	<div class="navbar">
		<div class="title">
			<span class="title-name">{{this.$project.projectName}}</span>
		</div>
		<el-dropdown class="dropdown-box" @command="handleCommand" trigger="click">
			<div class="el-dropdown-link">
				<el-image v-if="avatar" :src="avatar?this.$base.url + avatar : require('@/assets/img/avator.png')" fit="cover"></el-image>
				<span class="label">Welcome</span>
				<span class="nickname">{{this.$storage.get('adminName')}}</span>
				<span class="icon iconfont icon-xiala"></span>
			</div>
			<el-dropdown-menu class="top-el-dropdown-menu" slot="dropdown">
				<el-dropdown-item class="item1" :command="''">
					<span class="icon iconfont icon-home19"></span>
					Homepage
				</el-dropdown-item>
				<el-dropdown-item class="item2" :command="'center'">
					<span class="icon iconfont icon-touxiang09"></span>
					Personal Centre
				</el-dropdown-item>
				<el-dropdown-item class="item4" :command="'logout'">
					<span class="icon iconfont icon-guanbi19"></span>
					Exit Login
				</el-dropdown-item>
			</el-dropdown-menu>
		</el-dropdown>
	</div>
</template>

<script>
	import {
		Loading
	} from 'element-ui';
	import axios from 'axios';
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: null,
				topLogoUrl: '',
			};
		},
		created() {
			this.$http.get('config/info?name=bTopLogo',).then(rs=>{this.topLogoUrl = rs.data.data?rs.data.data.value:''})
		},
		computed: {
			avatar(){
				return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
			},
		},
		mounted() {
		},
		methods: {
			handleCommand(name) {
				if (name == 'logout') {
					this.onLogout()
				} 
				else {
					let router = this.$router
					name = '/'+name
					router.push(name)
				}
			},
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				this.$store.dispatch('tagsView/delAllViews')
				router.replace({
					name: "login"
				});
			},
		}
	};
</script>


<style lang="scss" scoped>
	.navbar {
		.title {
			padding: 0 0 0 45px;
			margin: 0 30px;
			color: #E3FDFC;
			background: url(http://codegen.caihongy.cn/20251011/21a31847b520427fb619caccbc2709f7.png) no-repeat left center / 32px  auto;
			flex: 1;
			font-weight: 600;
			display: flex;
			width: auto;
			font-size: 24px;
			align-items: center;
			height: 100%;
			.title-name {
				padding: 0;
				margin: 0 0px 0 0;
				color: inherit;
				font-weight: 600;
				font-size: 24px;
				line-height: 44px;
			}
		}
		.dropdown-box {
			color: #FDC748;
			display: flex;
			font-size: 16px;
			order: 11;
			.el-dropdown-link {
				border-radius: 8px;
				display: flex;
				width: 200px;
				justify-content: center;
				align-items: center;
				height: 58px;
				.el-image {
					border-radius: 100%;
					margin: 0 10px;
					object-fit: cover;
					display: inline-block;
					width: 32px;
					height: 32px;
				}
				.label {
					color: #2B345C;
					font-size: 16px;
					line-height: 32px;
				}
				.nickname {
					color: #2B345C;
					font-size: 16px;
					line-height: 32px;
				}
				.iconfont {
					margin: 0 0 0 5px;
					color: #2B345C;
					font-size: 14px;
				}
			}
		}
	}
	.top-el-dropdown-menu {
		border: 1px solid #EBEEF5;
		border-radius: 4px;
		padding: 10px 0;
		box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
		margin: 18px 0;
		background: #FFF;
		li.el-dropdown-menu__item.item1 {
			cursor: pointer;
			padding: 0 20px;
			margin: 0;
			outline: 0;
			color: #606266;
			background: #fff;
			font-size: 14px;
			line-height: 36px;
			list-style: none;
			.iconfont {
				margin: 0 4px 0 0;
				color: #000;
				font-size: 14px;
			}
		}
		li.el-dropdown-menu__item.item1:hover {
			background: #ecf5ff;
		}
		li.el-dropdown-menu__item.item2 {
			cursor: pointer;
			padding: 0 20px;
			margin: 0;
			outline: 0;
			color: #606266;
			background: #fff;
			font-size: 14px;
			line-height: 36px;
			list-style: none;
			.iconfont {
				margin: 0 4px 0 0;
				color: #000;
				font-size: 14px;
			}
		}
		li.el-dropdown-menu__item.item2:hover {
			background: #ecf5ff;
		}
		li.el-dropdown-menu__item.item4 {
			cursor: pointer;
			padding: 0 20px;
			margin: 0;
			outline: 0;
			color: #606266;
			background: #fff;
			font-size: 14px;
			line-height: 36px;
			list-style: none;
			.iconfont {
				margin: 0 4px 0 0;
				color: #000;
				font-size: 14px;
			}
		}
		li.el-dropdown-menu__item.item4:hover {
			background: #ecf5ff;
		}
	}
</style>
