









<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="E-Num" prop="shebeibianhao" >
					<el-input v-model="ruleForm.shebeibianhao" placeholder="E-Num" clearable  :readonly="ro.shebeibianhao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="E-Num" prop="shebeibianhao" >
					<el-input v-model="ruleForm.shebeibianhao" placeholder="E-Num" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="E-Name" prop="shebeimingcheng" >
					<el-input v-model="ruleForm.shebeimingcheng" placeholder="E-Name" clearable  :readonly="ro.shebeimingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="E-Name" prop="shebeimingcheng" >
					<el-input v-model="ruleForm.shebeimingcheng" placeholder="E-Name" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="E-Type" prop="shebeifenlei" >
					<el-input v-model="ruleForm.shebeifenlei" placeholder="E-Type" clearable  :readonly="ro.shebeifenlei"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="E-Type" prop="shebeifenlei" >
					<el-input v-model="ruleForm.shebeifenlei" placeholder="E-Type" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.shebeifengmian" label="E-Cover" prop="shebeifengmian" >
					<file-upload
						tip="Click to upload E-Cover"
						action="file/upload"
						:limit="3"
						:disabled="ro.shebeifengmian"
						:multiple="true"
						:fileUrls="ruleForm.shebeifengmian?ruleForm.shebeifengmian:''"
						@change="shebeifengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.shebeifengmian" label="E-Cover" prop="shebeifengmian" >
					<img v-if="ruleForm.shebeifengmian.substring(0,4)=='http'&&ruleForm.shebeifengmian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shebeifengmian" width="100" height="100">
					<img v-else-if="ruleForm.shebeifengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shebeifengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shebeifengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'" label="Loan-Num" prop="jiechushuliang" >
					<el-input v-model="jiechushuliang" placeholder="Loan-Num" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jiechushuliang" label="Loan-Num" prop="jiechushuliang" >
					<el-input v-model="ruleForm.jiechushuliang" placeholder="Loan-Num" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="returnnumber" prop="keyongshuliang" >
					<el-input v-model.number="ruleForm.keyongshuliang" placeholder="returnnumber" clearable  :readonly="ro.keyongshuliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="returnnumber" prop="keyongshuliang" >
					<el-input v-model="ruleForm.keyongshuliang" placeholder="returnnumber" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="Account" prop="zhanghao" >
					<el-input v-model="ruleForm.zhanghao" placeholder="Account" clearable  :readonly="ro.zhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="Account" prop="zhanghao" >
					<el-input v-model="ruleForm.zhanghao" placeholder="Account" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="Name" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="Name" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="Name" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="Name" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="Type" prop="leixing" >
					<el-input v-model="ruleForm.leixing" placeholder="Type" clearable  :readonly="ro.leixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="Type" prop="leixing" >
					<el-input v-model="ruleForm.leixing" placeholder="Type" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="Backtime" prop="guihaishijian" >
					<el-date-picker
						format="yyyy year MM month dd day"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.guihaishijian" 
						type="date"
						:readonly="ro.guihaishijian"
						placeholder="Backtime"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.guihaishijian" label="Backtime" prop="guihaishijian" >
					<el-input v-model="ruleForm.guihaishijian" placeholder="Backtime" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-queren15"></span>
					Confirmed
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-guanbi2"></span>
					Cancel
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui13"></span>
					Back
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
			var validateIntNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isIntNumer(value)) {
					callback(new Error("Please enter an integer."));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					shebeibianhao : false,
					shebeimingcheng : false,
					shebeifenlei : false,
					shebeifengmian : false,
					jiechushuliang : false,
					keyongshuliang : false,
					zhanghao : false,
					xingming : false,
					leixing : false,
					guihaishijian : false,
				},
			
				ruleForm: {
					shebeibianhao: '',
					shebeimingcheng: '',
					shebeifenlei: '',
					shebeifengmian: '',
					jiechushuliang: '',
					keyongshuliang: '',
					zhanghao: '',
					xingming: '',
					leixing: '',
					guihaishijian: '',
				},

				rules: {
					shebeibianhao: [
					],
					shebeimingcheng: [
					],
					shebeifenlei: [
					],
					shebeifengmian: [
					],
					jiechushuliang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					keyongshuliang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zhanghao: [
					],
					xingming: [
					],
					leixing: [
					],
					guihaishijian: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {
			sessionForm() {
				return JSON.parse(this.$storage.getObj('userForm'))
			},
			sessionTable() {
				return this.$storage.get('sessionTable')
			},
			jiechushuliang : {
				get: function () {
					let c = this.ruleForm
					let a = c.keyongshuliang
					this.ruleForm.jiechushuliang = a?Number(Number(a).toFixed(2)):0
					return a?Number(Number(a).toFixed(2)):0
				}
			},



		},
		components: {
		},
		created() {
			this.ruleForm.guihaishijian = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type ) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='shebeibianhao'){
							this.ruleForm.shebeibianhao = obj[o];
							this.ro.shebeibianhao = true;
							continue;
						}
						if(o=='shebeimingcheng'){
							this.ruleForm.shebeimingcheng = obj[o];
							this.ro.shebeimingcheng = true;
							continue;
						}
						if(o=='shebeifenlei'){
							this.ruleForm.shebeifenlei = obj[o];
							this.ro.shebeifenlei = true;
							continue;
						}
						if(o=='shebeifengmian'){
							this.ruleForm.shebeifengmian = obj[o];
							this.ro.shebeifengmian = true;
							continue;
						}
						if(o=='jiechushuliang'){
							this.ruleForm.jiechushuliang = obj[o];
							this.ro.jiechushuliang = true;
							continue;
						}
						if(o=='keyongshuliang'){
							this.ruleForm.keyongshuliang = obj[o];
							this.ro.keyongshuliang = true;
							continue;
						}
						if(o=='zhanghao'){
							this.ruleForm.zhanghao = obj[o];
							this.ro.zhanghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='leixing'){
							this.ruleForm.leixing = obj[o];
							this.ro.leixing = true;
							continue;
						}
						if(o=='guihaishijian'){
							this.ruleForm.guihaishijian = obj[o];
							this.ro.guihaishijian = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.sessionTable}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `guihaishebei/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.jiechushuliang==0){
						this.$message.error('Loan-Num Cannot be empty')
						return false
					}
					if(this.ruleForm.shebeifengmian!=null) {
						this.ruleForm.shebeifengmian = this.ruleForm.shebeifengmian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							let changeType = true
							let errMsg = ''
							if(this.type=='cross') {
								await this.$http.post('updateColumn/shebeixinxi/2',{
									csuUpdateColumn: 'jiechushuliang',
									csuUpdateColumnValue: '-' + this.ruleForm.jiechushuliang,
									csuConditionColumn: 'shebeibianhao',
									csuConditionColumnValue: this.ruleForm.shebeibianhao
								}).then(rs=>{
									if(rs.data.code!=0) {
										changeType = false
										errMsg = 'Update failed'
									}
								},err=>{
									changeType = false
									errMsg = 'Update failed'
								})
							}
							if(this.type=='cross') {
								await this.$http.post('updateColumn/shebeixinxi/2',{
									csuUpdateColumn: 'keyongshuliang',
									csuUpdateColumnValue: '+' + this.ruleForm.keyongshuliang,
									csuConditionColumn: 'shebeibianhao',
									csuConditionColumnValue: this.ruleForm.shebeibianhao
								}).then(rs=>{
									if(rs.data.code!=0) {
										changeType = false
										errMsg = 'Update failed'
									}
								},err=>{
									changeType = false
									errMsg = 'Update failed'
								})
							}
							if(!changeType) {
								this.$message.error(errMsg);
								return false
							}
							await this.$http({
								url: `guihaishebei/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "Operation successful",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.guihaishebeiCrossAddOrUpdateFlag = false;
											this.parent.search();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});
						}
					});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// Back
			back() {
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.guihaishebeiCrossAddOrUpdateFlag = false;
			},
			shebeifengmianUploadChange(fileUrls) {
				this.ruleForm.shebeifengmian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 30px 30px 30px 30px ;
		background: linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%);
	}
	.add-update-preview {
		border: 1px solid #fff;
		border-radius: 16px;
		padding: 50px 30px;
		background: #C2D7F2;
		display: flex;
		flex-wrap: wrap;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		margin: 0 0 10px 0;
		display: flex;
		width: 100%;
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
	.add-update-preview /deep/ .el-form-item.editorBox {
		margin: 10px 0 20px 0;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.editorBox /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 64px;
		text-align: right;
		height: 64px;
	}
	
	.add-update-preview .el-form-item.editorBox /deep/ .el-form-item__content {
		margin-left: auto !important;
		padding: 0;
		margin: auto !important;
		flex: 1;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor {
		border-radius: 4px;
		color: #2C365F;
		max-width: 100% !important;
		align-content: flex-start;
		flex: 1;
		background: none;
		display: flex;
		align-items: flex-start;
		flex-wrap: wrap;
		height: auto;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-toolbar {
		border: 1px solid #2C365F50;
		background: none;
		width: 100%;
		border-width: 1px 1px 0;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-container {
		border: 1px solid #2C365F50;
		background: none;
		width: 100%;
		min-height: 200px;
	}
	.add-update-preview /deep/.el-form-item.editorBox .editor .ql-container .ql-blank::before {
		color: #999;
	}
	
	.add-update-preview /deep/ .el-form-item.textBox {
		margin: 0 0 20px 0;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.textBox /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		background: none;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 64px;
		text-align: right;
		height: 64px;
	}
	
	.add-update-preview .el-form-item.textBox /deep/ .el-form-item__content {
		margin-left: auto !important;
		padding: 0;
		margin: auto !important;
		flex: 1;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview /deep/.el-form-item.textBox span.text {
		border: 1px solid #2C365F50;
		border-radius: 4px;
		padding: 12px 12px;
		outline: none;
		color: #2C365F;
		background: none;
		flex: 1;
		width: 100%;
		font-size: 16px;
		line-height: 30px;
		height: auto;
	}
	
	.add-update-preview .el-input {
		width: 100%;
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
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #2C365F;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #2C365F;
		flex: 1;
		background: none;
		width: 100%;
		font-size: 16px;
		line-height: 48px;
		height: 48px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
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
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #2C365F;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #2C365F;
		flex: 1;
		background: none;
		width: 100%;
		font-size: 16px;
		line-height: 48px;
		height: 48px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
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
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0px solid #2C365F;
		border-radius: 4px;
		padding: 0 12px;
		outline: none;
		color: #2C365F;
		flex: 1;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 48px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
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
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #2C365F;
		border-radius: 4px;
		padding: 0 30px;
		outline: none;
		color: #2C365F;
		flex: 1;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 48px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 30px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px  8px  8px  8px;
		outline: none;
		background: #2C365F;
		width: auto;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 30px;
		margin: 0;
		color: #FFFFFF;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px  8px  8px  8px;
		outline: none;
		background: #2C365F;
		width: auto;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0px solid #555555;
		cursor: pointer;
		padding: 0 30px;
		margin: 0;
		color: #2C365F;
		font-weight: 600;
		font-size: 14px;
		line-height: 50px;
		border-radius: 8px  8px  8px  8px;
		outline: none;
		background: #eee;
		width: auto;
		text-align: center;
		height: 50px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 40px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
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
	
	.add-update-preview /deep/ .upload .upload-img {
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
	.add-update-preview /deep/ .el-upload__tip {
		padding: 0 10px;
		color: #000000;
		font-size: 15px;
	}
	.add-update-preview /deep/ .el-form-item.fileupload {
		margin: 0 0 20px 0;
		display: flex;
		width: 100%;
	}
	.add-update-preview .el-form-item.fileupload /deep/ .el-form-item__label {
		padding: 0 10px;
		color: #000000;
		white-space: nowrap;
		font-weight: 400;
		width: 180px;
		font-size: 16px;
		line-height: 64px ;
		text-align: right;
		height: 64px ;
	}
	
	.add-update-preview .el-form-item.fileupload /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		flex: 1;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	.add-update-preview .el-form-item.fileupload /deep/ .el-upload-dragger {
		color: #333;
		display: flex;
		font-size: 16px;
		border-color: #2C365F50;
		flex-wrap: wrap;
		border-radius: 4px;
		outline: none;
		background:  none;
		width: 100%;
		border-width:  1px;
		align-items: center;
		border-style: solid;
		height: 100px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-icon-upload {
		margin: 0;
		color: #206cb480;
		width: 100%;
		font-size: 66px;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-upload__text {
		color: #606266;
		textalign: center;
		width: 100%;
		fontsize: 14px;
		line-height: 1;
	}
	.add-update-preview .el-form-item.fileupload .el-upload-dragger /deep/ .el-upload__text em {
		fontstyle: normal;
		color: #409EFF;
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
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
		border-radius: 4px;
		padding: 12px;
		outline: none;
		color: #2C365F;
		background: none;
		width: 100%;
		font-size: 16px;
		border-color: #2C365F;
		border-width: 0px;
		border-style: solid;
		height: auto;
	}
	.add-update-preview /deep/ .el-form-item.btn {
		padding: 0 30px;
		margin: 30px  auto 0 auto;
		background: none;
		display: flex;
		width: auto;
		justify-content: center;
		flex-wrap: wrap;
		.btn1 {
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
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
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
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
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
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #2C3C6F;
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
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #206cb4;
			cursor: pointer;
			padding: 0 24px;
			margin: 4px;
			color: #fff;
			font-weight: bold;
			font-size: 16px;
			border-radius: 24px  24px  24px  24px;
			outline: none;
			background: #2C3C6F;
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
		.btn5:hover {
			opacity: 0.8;
		}
	}
	.add-update-preview .el-form-item.btn /deep/ .el-form-item__label {
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
	
	.add-update-preview .el-form-item.btn /deep/ .el-form-item__content {
		margin-left: auto !important;
		margin: auto !important;
		flex: 1;
		display: flex;
		width: 100%;
		justify-content: flex-start;
		align-items: flex-start;
		flex-wrap: wrap;
	}
</style>
