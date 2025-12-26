<template>
	<div :style='{"padding":"30px 30px 30px 30px ","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)"}'>
		<el-form
			v-if="showType==1"
			:style='{"border":"1px solid #fff","padding":"50px 30px","borderRadius":"16px","flexWrap":"wrap","background":"#C2D7F2","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:rules="rules"
			:model="ruleForm"
			label-width="180px"
		>
			<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' label="Original password" prop="password">
				<el-input type="password" v-model="ruleForm.password" ></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' label="New password" prop="newpassword">
				<el-input type="password" v-model="ruleForm.newpassword" ></el-input>
			</el-form-item>
			<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' label="Confirm password" prop="repassword">
				<el-input type="password" v-model="ruleForm.repassword" ></el-input>
			</el-form-item>
			<el-form-item :style='{"padding":"0 30px","margin":"30px  auto 0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"auto","justifyContent":"center"}'>
				<el-button class="btn3" :style='{"border":"0px solid #206cb4","cursor":"pointer","padding":"0 24px","margin":"4px","color":"#435487","minWidth":"176px","outline":"none","borderRadius":"24px  24px  24px  24px","background":"#A4D348","width":"auto","fontSize":"16px","fontWeight":"bold","height":"47px"}' type="primary" @click="onUpdateHandler">
					<span class="icon iconfont icon-queren15" :style='{"margin":"0 2px","fontSize":"16px","color":"#fff","display":"none","height":"40px"}'></span>
					Confirmed
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script>
export default {
	data() {
		return {
			dialogVisible: false,
			ruleForm: {},
			payForm: {},
			user: {},
			rules: {
				password: [
					{
						required: true,
						message: "Password must not be empty",
						trigger: "blur"
					}
				],
				newpassword: [
					{
						required: true,
						message: "New password Cannot be empty",
						trigger: "blur"
					}
				],
				repassword: [
					{
						required: true,
						message: "Confirm password Cannot be empty",
						trigger: "blur"
					}
				]
			},
			rules2: {
				password: [
					{
						required: true,
						message: "支付Password must not be empty",
						trigger: "blur"
					}
				],
				newpassword: [
					{
						required: true,
						message: "新支付Password must not be empty",
						trigger: "blur"
					}
				],
				repassword: [
					{
						required: true,
						message: "确认支付Password must not be empty",
						trigger: "blur"
					}
				]
			},
			showType: '1'
		};
	},
	mounted() {
		this.$http({
			url: `${this.$storage.get("sessionTable")}/session`,
			method: "get"
		}).then(({ data }) => {
			if (data && data.code === 0) {
				this.user = data.data;
			} else {
				this.$message.error(data.msg);
			}
		});
	},
	methods: {
		onLogout() {
			this.$storage.remove("Token");
			this.$router.replace({ name: "login" });
		},
		// ChangePassword
		async onUpdateHandler() {
			this.$refs["ruleForm"].validate(async valid => {
				if (valid) {
					var password = "";
					if (this.user.mima) {
						password = this.user.mima;
					} else if (this.user.password) {
						password = this.user.password;
					}
					if(this.$storage.get("sessionTable")=='users'){
						if (this.ruleForm.password != password) {
							this.$message.error("Original password错误");
							return;
						}
						if (this.ruleForm.newpassword != this.ruleForm.repassword) {
							this.$message.error("两次Password输入不一致");
							return;
						}
						this.user.password = this.ruleForm.newpassword;
						this.user.mima = this.ruleForm.newpassword;
						this.$http({
							url: `${this.$storage.get("sessionTable")}/update`,
							method: "post",
							data: this.user
						}).then(({ data }) => {
							if (data && data.code === 0) {
								this.$message({
									message: "Change Password successful, effective upon next System login",
									type: "success",
									duration: 1500,
									onClose: () => {
									}
								});
							} else {
								this.$message.error(data.msg);
							}
						});
						return false
					}
					if (this.$storage.get("sessionTable") == 'renyuan') {
					}
					if (this.ruleForm.password != password) {
						this.$message.error("Original password错误");
						return;
					}
					if (this.ruleForm.newpassword != this.ruleForm.repassword) {
						this.$message.error("两次Password输入不一致");
						return;
					}
					if (this.ruleForm.newpassword == this.ruleForm.password) {
						this.$message.error("New password与Original password相同");
						return;
					}
					this.user.password = this.ruleForm.newpassword;
					this.user.mima = this.ruleForm.newpassword;
					this.$http({
						url: `${this.$storage.get("sessionTable")}/update`,
						method: "post",
						data: this.user
					}).then(({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: "Change Password successful, effective upon next System login",
								type: "success",
								duration: 1500,
								onClose: () => {
								}
							});
						} else {
							this.$message.error(data.msg);
						}
					});
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px;
	  	  color: #000000;
	  	  white-space: nowrap;
	  	  background: none;
	  	  font-weight: 600;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 48px;
	  	  text-align: right;
	  	  height: 64px;
	  	}
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		flex: 1;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border:  1px solid #2C365F;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #2C365F;
	  	  background: none;
	  	  flex: 1;
	  	  width: 100%;
	  	  font-size: 16px;
	  	  height: 48px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border:  1px solid #2C365F50;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  outline: none;
	  	  color: #2C365F;
	  	  background: none;
	  	  flex: 1;
	  	  width: 100%;
	  	  font-size: 16px;
	  	  height: 48px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border:  1px solid #2C365F50;
	  	  border-radius: 4px;
	  	  padding: 0 30px;
	  	  outline: none;
	  	  color: #2C365F;
	  	  background: none;
	  	  flex: 1;
	  	  width: 100%;
	  	  font-size: 16px;
	  	  height: 48px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border:  1px solid #2C365F50;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #2C365F;
	  	  background: none;
	  	  font-weight: 600;
	  	  width: 80px;
	  	  font-size: 30px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border:  1px solid #2C365F50;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  color: #2C365F;
	  	  background: none;
	  	  font-weight: 600;
	  	  width: 80px;
	  	  font-size: 30px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  outline: none;
	  	  color: #2C365F;
	  	  background: none;
	  	  width: 100%;
	  	  font-size: 16px;
	  	  border-color: #2C365F50;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  height: auto;
	  	}
	
	.add-update-preview .btn3 {
				border: 0px solid #206cb4;
				cursor: pointer;
				padding: 0 24px;
				margin: 4px;
				color: #435487;
				font-weight: bold;
				font-size: 16px;
				border-radius: 24px  24px  24px  24px;
				outline: none;
				background: #A4D348;
				width: auto;
				min-width: 176px;
				height: 47px;
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
</style>
