<template>
	<div>
		<div class="register-container" :style="{'backgroundImage': indexBgUrl?`url(${$base.url + indexBgUrl})`:''}">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">Inventory Management SystemRegistration</div>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-input  v-model="ruleForm.zhanghao" :readonly="ro.zhanghao" autocomplete="off" placeholder="Account"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-input  v-model="ruleForm.mima" :readonly="ro.mima" autocomplete="off" placeholder="Password"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="Confirm password" type="password" :readonly="ro.mima" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-input  v-model="ruleForm.xingming" :readonly="ro.xingming" autocomplete="off" placeholder="Name"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-select filterable v-model="ruleForm.xingbie" placeholder="Please select Gender" :disabled="ro.xingbie">
							<el-option
								v-for="(item,index) in renyuanxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<file-upload
							tip="Click to upload Profile picture"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="renyuantouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-select filterable v-model="ruleForm.leixing" placeholder="Please select Type" :disabled="ro.leixing">
							<el-option
								v-for="(item,index) in renyuanleixingOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='renyuan'">
						<el-input  v-model="ruleForm.lianxifangshi" :readonly="ro.lianxifangshi" autocomplete="off" placeholder="Contact details"  type="text"  />
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">Registration</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()"> 已有Account，立即Login</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
			ro: {},
            renyuanxingbieOptions: [],
            renyuanleixingOptions: [],
			indexBgUrl: '',
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='renyuan'){
				this.ruleForm = {
					zhanghao: '',
					mima: '',
					xingming: '',
					xingbie: '',
					touxiang: '',
					leixing: '',
					lianxifangshi: '',
				}
				this.ro = {
					zhanghao: false,
					mima: false,
					xingming: false,
					xingbie: false,
					touxiang: false,
					leixing: false,
					lianxifangshi: false,
				}
			}
			if ('renyuan' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: 'Please enter Account', trigger: 'blur' }]
			}
			if ('renyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: 'Please enter your password', trigger: 'blur' }]
			}
			if ('renyuan' == this.tableName) {
				this.rules.xingming = [{ required: true, message: 'Please enter Name', trigger: 'blur' }]
			}
			this.renyuanxingbieOptions = "Boy,Female".split(',')
			this.renyuanleixingOptions = "Student,Teacher".split(',')
		}
	},
	created() {
		this.$http.get('config/info?name=bRegisterBackgroundImg',).then(rs=>{this.indexBgUrl = rs.data.data?rs.data.data.value:''})
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        renyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// Registration
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.zhanghao) && `renyuan` == this.tableName){
				this.$message.error(`Account Cannot be empty`);
				return
			}
			if((!this.ruleForm.mima) && `renyuan` == this.tableName){
				this.$message.error(`Password must not be empty`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `renyuan` == this.tableName){
				this.$message.error(`两次Password输入不一致`);
				return
			}
			if((!this.ruleForm.xingming) && `renyuan` == this.tableName){
				this.$message.error(`Name Cannot be empty`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if(`renyuan` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`Contact details应输入手机格式`);
				return
			}
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "Registration成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		},
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20251011/0cd6f40df40c465ca6a9fc607e15b046.png)  no-repeat  center   center /  100% 100%;
	background: url(http://codegen.caihongy.cn/20251011/0cd6f40df40c465ca6a9fc607e15b046.png)  no-repeat  center   center /  100% 100%;
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	position: relative;
	.rgs-form {
		.rgs-form2 {
		border-radius: 54px;
		padding: 20px 57px ;
		margin: auto  74px auto  0;
		background: none;
		display: flex;
		width: 649px;
		flex-wrap: wrap;
		}
		border-radius: 0;
		padding: 0;
		z-index: 1;
		flex-direction: column;
		display: flex;
		width: 100%;
		align-items: flex-end;
		flex-wrap: wrap;
		height: auto;
		.title {
			margin: 10px  0 10px 0;
			text-shadow: none;
			color: #FFF6F0;
			background: none;
			font-weight: 600;
			width: 100%;
			font-size: 26px;
		}
		.list-item {
			border-radius: 5px;
			padding: 0;
			margin: 10px 0;
			width: 100%;
			/deep/ .el-form-item__content {
				display: block;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 30px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid #DADFE6;
				border-radius: 4px;
				padding: 0 30px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 4px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				margin: 10px 0 0;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 26px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 4px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				margin: 10px 0 0;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 26px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 4px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				margin: 10px 0 0;
				color: #999;
				background: #fff;
				width: 90px;
				font-size: 26px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #DCE9F9;
				font-size: 16px;
			}
			/deep/ .el-input__inner::placeholder {
				color: #9E9E9E;
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 120px;
				position: absolute;
				content: "*";
			}
			.editor {
				border: 1px solid  #DADFE6;
				border-radius: 4px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				background: #fff;
				width: 100%!important;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid #DADFE6;
				border-radius: 4px 0 0 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				flex: 1;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			input:focus {
				border: 1px solid #DADFE6;
				border-radius: 4px 0 0 4px;
				padding: 0 10px;
				box-shadow: inset 0px 3px 6px 1px rgba(0,0,0,0.16);
				color: #333;
				flex: 1;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 45px;
			}
			input::placeholder {
				color: #9E9E9E;
				font-size: 16px;
			}
			button {
				border: 0;
				cursor: pointer;
				padding: 0 10px;
				margin: 0;
				color: #fff;
				font-size: 16px;
				border-color: #d1d1d1;
				border-radius: 0 4px 4px 0;
				box-shadow: none;
				outline: none;
				background: #A4D348;
				width: 130px;
				border-width: 0 0 0px;
				border-style: solid;
				height: 45px;
			}
			button:hover {
				color: #fff;
			}
		}
		.register-btn {
			margin: 20px 0;
			display: flex;
			width: 100%;
			justify-content: center;
			flex-wrap: wrap;
		}
		.register-btn1 {
			margin: 0 10px 0 0;
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0;
			cursor: pointer;
			border-radius: 24px;
			outline: none;
			color: #fff;
			background: #A4D348;
			font-weight: bold;
			width: 100%;
			font-size: 16px;
			height: 45px;
		}
		.r-btn:hover {
			opacity: 0.5;
		}
		.r-login {
			border: 0;
			cursor: pointer;
			padding: 0 24px;
			margin: 10px 0;
			color: #DCE9F9;
			font-weight: bold;
			font-size: 16px;
			line-height: 45px;
			border-radius: 24px;
			outline: none;
			background: none;
			width: 100%;
			text-align: center;
			height: 45px;
		}
		.r-login:hover {
			opacity: 0.8;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
