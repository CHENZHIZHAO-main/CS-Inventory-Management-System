<template>
	<div :style='{"padding":"30px 20px","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)"}'>
		<el-form
			:style='{"border":"1px solid #fff","padding":"50px 30px","borderRadius":"16px","flexWrap":"wrap","background":"#C2D7F2","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}'   v-if="flag=='renyuan'"  label="Account" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" :readonly="ro.zhanghao" placeholder="Account" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}'   v-if="flag=='renyuan'"  label="Name" prop="xingming">
					<el-input v-model="ruleForm.xingming" :readonly="ro.xingming" placeholder="Name" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' v-if="flag=='renyuan'"  label="Gender" prop="xingbie">
					<el-select filterable v-model="ruleForm.xingbie" :disabled="ro.xingbie" placeholder="Please select Gender">
						<el-option
							v-for="(item,index) in renyuanxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' v-if="flag=='renyuan'" label="Profile picture" prop="touxiang">
					<file-upload
						tip="Click to upload Profile picture"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="renyuantouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' v-if="flag=='renyuan'"  label="Type" prop="leixing">
					<el-select filterable v-model="ruleForm.leixing" :disabled="ro.leixing" placeholder="Please select Type">
						<el-option
							v-for="(item,index) in renyuanleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}'   v-if="flag=='renyuan'"  label="Contact details" prop="lianxifangshi">
					<el-input v-model="ruleForm.lianxifangshi" :readonly="ro.lianxifangshi" placeholder="Contact details" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' v-if="flag=='users'" label="Name" prop="username">
					<el-input v-model="ruleForm.username" placeholder="Name"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"100%","margin":"0 0 10px 0","display":"flex"}' v-if="flag=='users'" label="Profile picture" prop="image">
					<file-upload
						tip="Click to upload Profile picture"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 30px","margin":"30px  auto 0 auto","flexWrap":"wrap","background":"none","display":"flex","width":"auto","justifyContent":"center"}'>
					<el-button class="btn3" type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-queren15"></span>
						Confirmed
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
	import { 
		isMobile,
	} from "@/utils/validate";

	export default {
		data() {
			return {
				ruleForm: {},
				flag: '',
				usersFlag: false,
				renyuanxingbieOptions: [],
				renyuanleixingOptions: [],
			};
		},
		mounted() {
			var table = this.$storage.get("sessionTable");
			this.flag = table;
			this.$http({
				url: `${this.$storage.get("sessionTable")}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(table == 'renyuan') {
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

					this.ruleForm = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.renyuanxingbieOptions = "Boy,Female".split(',')
			this.renyuanleixingOptions = "Student,Teacher".split(',')
		},
		methods: {
			renyuantouxiangUploadChange(fileUrls) {
				this.ruleForm.touxiang = fileUrls;
			},
			usersimageUploadChange(fileUrls) {
				this.ruleForm.image = fileUrls;
			},
			onUpdateHandler() {
				if((!this.ruleForm.zhanghao)&& 'renyuan'==this.flag){
					this.$message.error('Account Cannot be empty');
					return
				}
				if((!this.ruleForm.mima)&& 'renyuan'==this.flag){
					this.$message.error('Password must not be empty');
					return
				}
				if((!this.ruleForm.xingming)&& 'renyuan'==this.flag){
					this.$message.error('Name Cannot be empty');
					return
				}
				if(this.ruleForm.touxiang!=null) {
					this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
				}
				if('renyuan' ==this.flag && this.ruleForm.lianxifangshi&&(!isMobile(this.ruleForm.lianxifangshi))){
					this.$message.error(`Contact details应输入手机格式`);
					return
				}
				if('users'==this.flag && this.ruleForm.username.trim().length<1) {
					this.$message.error(`Name Cannot be empty`);
					return	
				}
				if(this.flag=='users'){
					this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
				}
				this.$http({
					url: `${this.$storage.get("sessionTable")}/update`,
					method: "post",
					data: this.ruleForm
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(this.flag=='users'){
							this.$storage.set('headportrait',this.ruleForm.image)
						}else {
							if(this.flag == 'renyuan') {
								this.$storage.set('headportrait',this.ruleForm.touxiang)
							}
						}
						this.$message({
							message: "Information successfully modified",
							type: "success",
							duration: 1500,
							onClose: () => {
								window.location.reload();
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
				.iconfont {
						margin: 0 2px;
						color: #fff;
						display: none;
						font-size: 16px;
						height: 40px;
					}
	}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
