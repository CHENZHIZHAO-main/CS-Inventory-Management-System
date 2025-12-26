const base = {
	get() {
		return {
			url : "http://localhost:8080/inventoryx00baf6t/",
			name: "inventoryx00baf6t",
			// Exit 到Homepage链接
			indexUrl: ''
		};
	},
	getProjectName(){
		return {
			projectName: "Inventory Management System"
		} 
	},
	getUsersName(){
		return {
			usersname: 'admin'
		}
	},
	getBgName() {
		return {
			bgNameList: [
				{
					name: '后台Login页',
					value: 'bLoginBackgroundImg'
				},
				{
					name: '后台Registration页',
					value: 'bRegisterBackgroundImg'
				},
				{
					name: '后台Homepage',
					value: 'bIndexBackgroundImg'
				},
				{
					name: '后台头部LOGO',
					value: 'bTopLogo'
				},
				{
					name: '后台HomepageLOGO',
					value: 'bHomeLogo'
				},
				{
					name: '前台Login页',
					value: 'fLoginBackgroundImg'
				},
				{
					name: '前台Registration页',
					value: 'fRegisterBackgroudImg'
				},
				{
					name: '前台头部LOGO',
					value: 'fTopLogo'
				},
				{
					name: 'APPLogin页',
					value: 'appLoginBackgroundImg'
				},
				{
					name: 'APPRegistration页',
					value: 'appRegisterBackgroudImg'
				},
				{
					name: 'APPLogin页LOGO',
					value: 'appLoginLogo'
				},
				{
					name: 'APPRegistration页LOGO',
					value: 'appRegLogo'
				},
			]
		}
	}
}
export default base
