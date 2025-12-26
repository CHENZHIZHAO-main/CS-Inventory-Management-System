  
<template>
	<div class="main-content" :style='{"padding":"30px 20px","background":"linear-gradient( 180deg, #EBF4FF 0%, #CDDEF3 49%, #E1EDFB 100%)"}'>
		<!-- 列表页 -->
		<template v-if="showFlag  &&!statType ">
			<el-form class="center-form-pv" :style='{"border":"1px solid #fff","width":"100%","padding":"0","margin":"0","borderRadius":"16px","background":"#C2D7F2"}' :inline="true" :model="searchForm">
				<el-row :style='{"width":"100%","padding":"30px","position":"relative","flexWrap":"wrap","display":"flex"}' >
					<div  :style='{"margin":"0 1% 10px 0","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","whiteSpace":"nowrap","color":"#333333","lineHeight":"40px","fontSize":"16px","fontWeight":"400","height":"40px"}' class="item-label">设备名称</label>
						<el-input v-model="searchForm.shebeimingcheng" placeholder="设备名称" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div  :style='{"margin":"0 1% 10px 0","display":"flex"}' class="select" label="设备分类" prop="shebeifenlei">
						<label :style='{"margin":"0 10px 0 0","whiteSpace":"nowrap","color":"#333333","lineHeight":"40px","fontSize":"16px","fontWeight":"400","height":"40px"}' class="item-label">设备分类</label>
						<el-select clearable v-model="searchForm.shebeifenlei" placeholder="请选择设备分类" >
							<el-option v-for="(item,index) in shebeifenleiOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-fangdajing01" :style='{"margin":"0 0px","fontSize":"16px","color":"#435487","height":"40px"}'></span>
						查询
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"width":"100%","padding":"0 30px 30px 30px","flexWrap":"wrap","display":"flex"}'>
					<el-button class="add" v-if="isAuth('shebeixinxi','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia1" :style='{"margin":"0 0px","fontSize":"16px","color":"#fff","height":"auto"}'></span>
						新增
					</el-button>
					<el-button class="del" v-if="isAuth('shebeixinxi','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu6" :style='{"margin":"0 0px","fontSize":"16px","color":"#fff","height":"auto"}'></span>
						删除
					</el-button>


				</el-row>
			</el-form>
			<div :style='{"border":"1px solid #fff","width":"100%","padding":"20px","margin":"30px 0 0 0","borderRadius":"16px","background":"#C2D7F2"}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#2C365F","borderRadius":"0","borderWidth":"0px 0 0 0px","background":"none","width":"100%","borderStyle":"solid"}' 
					:border='false'
					v-if="isAuth('shebeixinxi','查看')"
					:data="dataList"
					v-loading="dataListLoading"
					@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeibianhao"
						label="设备编号">
						<template slot-scope="scope">
							{{scope.row.shebeibianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeimingcheng"
						label="设备名称">
						<template slot-scope="scope">
							{{scope.row.shebeimingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeifenlei"
						label="设备分类">
						<template slot-scope="scope">
							{{scope.row.shebeifenlei}}
						</template>
					</el-table-column>
					<el-table-column  :resizable='true' prop="shebeifengmian" width="200" label="设备封面">
						<template slot-scope="scope">
							<div v-if="scope.row.shebeifengmian">
								<img v-if="scope.row.shebeifengmian.substring(0,4)=='http'&&scope.row.shebeifengmian.split(',w').length>1" :src="scope.row.shebeifengmian" width="100" height="100" style="object-fit: cover" @click="imgPreView(scope.row.shebeifengmian)">
								<img v-else-if="scope.row.shebeifengmian.substring(0,4)=='http'" :src="scope.row.shebeifengmian.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView(scope.row.shebeifengmian.split(',')[0])">
								<img v-else :src="$base.url+scope.row.shebeifengmian.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView($base.url+scope.row.shebeifengmian.split(',')[0])">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeixinghao"
						label="设备型号">
						<template slot-scope="scope">
							{{scope.row.shebeixinghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeipinpai"
						label="设备品牌">
						<template slot-scope="scope">
							{{scope.row.shebeipinpai}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeiguige"
						label="设备规格">
						<template slot-scope="scope">
							{{scope.row.shebeiguige}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="shebeizongshu"
						label="设备总数">
						<template slot-scope="scope">
							{{scope.row.shebeizongshu}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="jiechushuliang"
						label="借出数量">
						<template slot-scope="scope">
							{{scope.row.jiechushuliang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="keyongshuliang"
						label="可用数量">
						<template slot-scope="scope">
							{{scope.row.keyongshuliang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'
												prop="zhuyishixiang"
						label="注意事项">
						<template slot-scope="scope">
							{{scope.row.zhuyishixiang}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('shebeixinxi','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan2" :style='{"margin":"0 0px","fontSize":"14px","color":"#333","display":"none","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="btn8" v-if="isAuth('shebeixinxi','借用')" @click="jiechushebeiCrossAddOrUpdateHandler(scope.row,'cross','','','','')" type="success">
								<span class="icon iconfont icon-xihuan" :style='{"margin":"0 0px","fontSize":"14px","color":"#333","display":"none","height":"40px"}'></span>
								借用
							</el-button>
							<el-button class="edit" v-if=" isAuth('shebeixinxi','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai13" :style='{"margin":"0 0px","fontSize":"14px","color":"rgba(255, 140, 0, 1)","display":"none","height":"40px"}'></span>
								修改
							</el-button>




							<el-button class="del" v-if="isAuth('shebeixinxi','删除')" type="primary" @click="deleteHandler(scope.row.id)">
								<span class="icon iconfont icon-shanchu6" :style='{"margin":"0 0px","fontSize":"14px","color":"rgba(220, 38, 38, 1)","display":"none","height":"40px"}'></span>
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="< "
				next-text="> "
				:hide-on-single-page="false"
				:style='{"padding":"20px 0","margin":"0","whiteSpace":"nowrap","color":"#333","borderRadius":"0px  0px  24px  24px","display":"flex","width":"100%","fontWeight":"500","justifyContent":"flex-end"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<jiechushebei-cross-add-or-update v-if="jiechushebeiCrossAddOrUpdateFlag" :parent="this" ref="jiechushebeiCrossaddOrUpdate"></jiechushebei-cross-add-or-update>



		<template v-if="statType">
			<div class="statShow1">
				<div class="echarts1" v-if="isAuth('shebeixinxi','库存统计')">
					<div id="shebeimingchengChart1" style=" width: 100%;height: 100%"></div>
				</div>
			</div>
		</template>

		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
	import * as echarts from 'echarts'
	import chinaJson from "@/components/echarts/china.json";
	import axios from 'axios';
	import AddOrUpdate from "./add-or-update";
	import jiechushebeiCrossAddOrUpdate from "../jiechushebei/add-or-update";
	import {
		Loading
	} from 'element-ui';
	export default {
		data() {
			return {
				indexQueryCondition: '',
				shebeifenleiOptions: [],
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#698AE5","#2A345B","#A4D348","#4FB7F1","#2CD89E","#89e6d8","#4495ac","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":6000,"symbol":"image://http://codegen.caihongy.cn/20251017/1c88d9cb94ce458fb6e481abb0d74998.png","label":{"color":"#725BFF","show":false,"position":"top"},"symbolSize":[20,15],"symbolOffset":[0,1],"animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"}},
				bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"grid":{"right":"20","top":"60","left":"20","bottom":"20","containLabel":true},"series":{"barWidth":"12px","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#f2f8d4","shadowOffsetY":0,"color":{"x":0,"y":0,"y2":1,"x2":0,"global":false,"colorStops":[{"offset":0,"color":"#2D3761"},{"offset":1,"color":"#698AE5"}],"type":"linear"},"shadowBlur":0,"borderWidth":0,"barBorderRadius":[24,24,0,0],"opacity":1,"shadowColor":"#000"},"colorBy":"data","label":{"formatter":"","show":true,"position":"top"},"barCategoryGap":"30%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"subtext":"","shadowBlur":0,"bottom":"auto","show":true,"right":"auto","subtextStyle":{"padding":[5,0,0,0],"borderColor":"red","color":"red","borderWidth":10},"top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
				pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"title":{"borderType":"solid","padding":[5,0,0,0],"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":[5,0,0,0],"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":0,"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#8838FF"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#666","color":"inherit","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#666","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#8838FF","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#8838FF"},"length2":14,"smooth":false}}},
				funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"center","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
				boardBase: {"funnelNum":8,"lineNum":8,"radarNum":8,"gaugeNum":8,"barNum":8,"pieNum":8},
				gauge: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#333"}},"backgroundColor":"transparent","color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"title":{"top":"top","left":"left","textStyle":{"fontSize":14,"lineHeight":24,"color":"#333","fontWeight":600}},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":25,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":3,"width":20,"fontSize":12,"height":10},"title":{"fontSize":14},"animation":true}},
				radar: {"backgroundColor":"transparent","radar":{"shape":"circle"},"color":["#698AE5","#2A345B","#A4D348","#7690cb","#49ada0","#5BBAEC","#a68a28","#EE142F","#FFE9E9"],"legend":{"padding":5,"itemGap":5,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":4,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":4,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#333"}},"title":{"top":"top","left":"left","textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0}}},
				chartVisiable1: false,
				addOrUpdateFlag:false,
				jiechushebeiCrossAddOrUpdateFlag: false,
				layouts: ["total","prev","pager","next","sizes","jumper"],
				previewImg: '',
				previewVisible: false,
			};
		},
		created() {
			if(this.statType) {
				return false
			}
			this.init();
			this.getDataList();
		},
		mounted() {
			if(this.statType) {
				this.statChartClick()
			}
		},
		watch: {
			statType(newsValue) {
				if(newsValue) {
					this.statChartClick()
				}
			},
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
			role(){
				return this.$storage.get('role')
			},
			statType() {
				return this.$route.path.endsWith('stat')
			}
		},
		components: {
			AddOrUpdate,
			jiechushebeiCrossAddOrUpdate,
		},
		methods: {
			statChartClick() {
				if(this.isAuth('shebeixinxi','库存统计')) {
					this.chartDialogShow1()
				}
			},
			queryChange(arr){
				for(let x in arr) {
					if(arr[x] == this.role) {
						return true
					}
				}
				return false
			},
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
				
			},
			jiechushebeiCrossAddOrUpdateHandler(row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue){
				this.showFlag = false;
				this.addOrUpdateFlag = false;
				this.jiechushebeiCrossAddOrUpdateFlag = true;
				this.$storage.set('crossObj',row);
				this.$storage.set('crossTable','shebeixinxi');
				this.$storage.set('statusColumnName',statusColumnName);
				this.$storage.set('statusColumnValue',statusColumnValue);
				this.$storage.set('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								message: tips,
								type: "warning",
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
							this.showFlag = true;
							this.jiechushebeiCrossAddOrUpdateFlag = false;
							return;
						}
					}
				}
				this.$nextTick(() => {
					this.$refs.jiechushebeiCrossaddOrUpdate.init(row.id,type);
				});
			},
			changeStatQuery(arr) {
				if(arr.length==1) {
					if(arr[0] == 'users'&&this.$storage.get("sessionTable")=='users') {
						return true
					}
				}
				for(let x in arr) {
					if(arr[x] == this.role) {
						return true
					}
				}
				return false
			},
			chartDialogShow1() {
				this.chartVisiable1 = true
				this.chartDialog1()
			},
			// 统计接口1
			chartDialog1() {
				this.$nextTick(()=>{
					var shebeimingchengChart1 = echarts.init(document.getElementById("shebeimingchengChart1"),'macarons');
					let params = {}
					this.$http({
						url: "shebeixinxi/valueMul/shebeimingcheng?yColumnNameMul=shebeizongshu,jiechushuliang,keyongshuliang",
						method: "get",
						params
					}).then(({data})=>{
						if (data && data.code === 0) {
							let res = data.data;
							let xAxis1 = [];
							let yAxis1 = [];
							let pArray1 = [];
							for(let i=0;i<res[0].length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis1.push(res[0][i].shebeimingcheng);
								yAxis1.push(parseFloat((res[0][i].total)));
								pArray1.push({
									value: parseFloat((res[0][i].total)),
									name: res[0][i].shebeimingcheng
								})
							}
							let xAxis2 = [];
							let yAxis2 = [];
							let pArray2 = [];
							for(let i=0;i<res[1].length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis2.push(res[1][i].shebeimingcheng);
								yAxis2.push(parseFloat((res[1][i].total)));
								pArray2.push({
									value: parseFloat((res[1][i].total)),
									name: res[1][i].shebeimingcheng
								})
							}
							let xAxis3 = [];
							let yAxis3 = [];
							let pArray3 = [];
							for(let i=0;i<res[2].length;i++){
								if(this.boardBase&&i==this.boardBase.lineNum){
									break;
								}
								xAxis3.push(res[2][i].shebeimingcheng);
								yAxis3.push(parseFloat((res[2][i].total)));
								pArray3.push({
									value: parseFloat((res[2][i].total)),
									name: res[2][i].shebeimingcheng
								})
							}
							var option = {};
							let titleObj = this.line.title
							titleObj.text = '库存统计'
							
							const legendObj = this.line.legend
							legendObj.data = [
								'设备总数'.split('/').length>1?'设备总数'.split('/')[0]:'设备总数',
								'借出数量'.split('/').length>1?'借出数量'.split('/')[0]:'借出数量',
								'可用数量'.split('/').length>1?'可用数量'.split('/')[0]:'可用数量',
							]
							
							let xAxisObj = this.line.xAxis
							xAxisObj.type = 'category'
							
							xAxisObj.data = xAxis1
							
							let yAxisObj = this.line.yAxis
							yAxisObj.type = 'value'
							
							let seriesObj = [
								{
									data: yAxis1,
									type: '设备总数'.split('/').length>1?'设备总数'.split('/')[1]:'line',
									name: '设备总数'.split('/').length>1?'设备总数'.split('/')[0]:'设备总数',
								},
								{
									data: yAxis2,
									type: '借出数量'.split('/').length>1?'借出数量'.split('/')[1]:'line',
									name: '借出数量'.split('/').length>1?'借出数量'.split('/')[0]:'借出数量',
								},
								{
									data: yAxis3,
									type: '可用数量'.split('/').length>1?'可用数量'.split('/')[1]:'line',
									name: '可用数量'.split('/').length>1?'可用数量'.split('/')[0]:'可用数量',
								},
							]
							for(let i=0;i<seriesObj.length;i++){
								seriesObj[i] = Object.assign(seriesObj[i] , this.line.series)
							}
							const gridObj = this.line.grid
							let tooltipObj = {trigger: 'axis'}
							tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
							option = {
								backgroundColor: this.line.backgroundColor,
								color: this.line.color,
								title: titleObj,
								legend: legendObj,
								grid: gridObj,
								tooltip: tooltipObj,
								xAxis: xAxisObj,
								yAxis: yAxisObj,
								series: seriesObj
							};
							// 使用刚指定的配置项和数据显示图表。
							shebeimingchengChart1.setOption(option);
							  //根据窗口的大小变动图表
							window.onresize = function() {
								shebeimingchengChart1.resize();
							};
						}
					})
				})
			},
			init () {
				this.$http({
					url: `option/shebeifenlei/shebeifenlei`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.shebeifenleiOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			search() {
				this.pageIndex = 1;
				this.getDataList();
			},

			// 获取数据列表
			getDataList() {
				this.dataListLoading = true;
				let params = {
					page: this.pageIndex,
					limit: this.pageSize,
					sort: 'id',
					order: 'desc',
				}
				if(this.searchForm.shebeimingcheng!='' && this.searchForm.shebeimingcheng!=undefined){
					params['shebeimingcheng'] = '%' + this.searchForm.shebeimingcheng + '%'
				}
				if(this.searchForm.shebeifenlei!='' && this.searchForm.shebeifenlei!=undefined){
					params['shebeifenlei'] = this.searchForm.shebeifenlei
				}
				let user = JSON.parse(this.$storage.getObj('userForm'))
				this.$http({
					url: "shebeixinxi/page",
					method: "get",
					params: params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.dataList = data.data.list;
						this.totalPage = data.data.total;
					} else {
						this.dataList = [];
						this.totalPage = 0;
					}
					this.dataListLoading = false;
				});
			},
			// 每页数
			sizeChangeHandle(val) {
				this.pageSize = val;
				this.pageIndex = 1;
				this.getDataList();
			},
			// 当前页
			currentChangeHandle(val) {
				this.pageIndex = val;
				this.getDataList();
			},
			// 多选
			selectionChangeHandler(val) {
				this.dataListSelections = val;
			},
			// 添加/修改
			addOrUpdateHandler(id,type) {
				this.showFlag = false;
				this.addOrUpdateFlag = true;
				this.crossAddOrUpdateFlag = false;
				if(type!='info'&&type!='msg'){
					type = 'else';
				}
				this.$nextTick(() => {
					this.$refs.addOrUpdate.init(id,type );
				});
			},
			// 删除
			async deleteHandler(id ) {
				var ids = id? [Number(id)]: this.dataListSelections.map(item => {
					return Number(item.id);
				});
				await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(async () => {
					await this.$http({
						url: "shebeixinxi/delete",
						method: "post",
						data: ids
					}).then(async ({ data }) => {
						if (data && data.code === 0) {
							this.$message({
								message: "操作成功",
								type: "success",
								duration: 1500,
								onClose: () => {
									this.search();
								}
							});
			
						} else {
							this.$message.error(data.msg);
						}
					});
				});
			},


		}

	};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
		.el-date-editor.el-input {
			width: auto;
		}
	}
	
	.el-input {
		width: auto;
	}
	
	// form
	.center-form-pv .el-input {
		width: 100%;
	}
	.center-form-pv .el-input /deep/ .el-input__inner {
		border: 1px solid #2C365F;
		border-radius: 4px;
		padding: 0 12px;
		box-shadow: none;
		outline: none;
		color: #2C365F;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.center-form-pv .el-select {
		width: 100%;
	}
	.center-form-pv .el-select /deep/ .el-input__inner {
		border: 1px solid #2C365F;
		border-radius: 4px;
		padding: 0 12px;
		box-shadow: none;
		outline: none;
		color: #2C365F;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	.center-form-pv .el-date-editor {
		width: 100%;
	}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #2C365F;
		border-radius: 4px;
		padding: 0 30px;
		box-shadow: none;
		outline: none;
		color: #2C365F;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 41px;
	}
	
	.center-form-pv .search {
		border: 0;
		cursor: pointer;
		border-radius: 24px;
		padding: 0 12px 0 10px;
		outline: none;
		color: #435487;
		background: #A4D348;
		font-weight: bold;
		width: auto;
		font-size: 16px;
		min-width: 110px;
		height: 41px;
	}
	
	.center-form-pv .search:hover {
		opacity: 0.8;
	}
	
	.center-form-pv .actions .add {
		border: 0;
		cursor: pointer;
		border-radius: 24px;
		padding: 0 15px;
		margin: 4px;
		outline: none;
		color: #fff;
		background: #2C365F;
		width: auto;
		font-size: 14px;
		height: 41px;
	}
	
	.center-form-pv .actions .add:hover {
		opacity: 0.8;
	}
	
	.center-form-pv .actions .del {
		border: 0;
		cursor: pointer;
		border-radius: 24px;
		padding: 0 15px;
		margin: 4px;
		outline: none;
		color: #fff;
		background: #2C365F;
		width: auto;
		font-size: 14px;
		height: 41px;
	}
	
	.center-form-pv .actions .del:hover {
		opacity: 0.8;
	}
	
	.center-form-pv .actions .statis {
		border: 0;
		cursor: pointer;
		border-radius: 24px;
		padding: 0 15px;
		margin: 4px;
		outline: none;
		color: #fff;
		background: #2C365F;
		width: auto;
		font-size: 14px;
		height: 41px;
	}
	
	.center-form-pv .actions .statis:hover {
		opacity: 0.8;
	}
	
	.center-form-pv .actions .btn18 {
		border: 0;
		cursor: pointer;
		border-radius: 24px;
		padding: 0 15px;
		margin: 4px;
		outline: none;
		color: #435487;
		background: #A4D348;
		width: auto;
		font-size: 14px;
		height: 41px;
	}
	
	.center-form-pv .actions .btn18:hover {
		opacity: 0.8;
	}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
		color: #000000;
		font-weight: 400;
		width: 100%;
	}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
		background: none;
	}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
		padding: 12px 0;
		background: none;
		border-color: #545454;
		border-width: 0;
		border-style: dotted;
		text-align: center;
	}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
		padding: 0 0 0 5px;
		word-wrap: normal;
		color: #212D3F;
		white-space: normal;
		font-weight: 400;
		display: flex;
		vertical-align: middle;
		font-size: 15px;
		line-height: 24px;
		text-overflow: ellipsis;
		word-break: break-all;
		width: 100%;
		justify-content: flex-start;
		align-items: center;
		position: relative;
		min-width: 110px;
	}

	.el-table /deep/ .el-table__body-wrapper {
		position: relative;
	}
	.el-table /deep/ .el-table__body-wrapper tbody {
		width: 100%;
	}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
		color: #212D3F;
		background: none;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
		padding: 4px 0;
		color: #000000;
		background: none;
		border-color: #2C365F;
		border-width: 0 0px 1px 0;
		border-style: solid;
		text-align: left;
	}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
		padding: 4px 0;
		color: #fff;
		background: linear-gradient( 180deg, #8091C0 0%, #455689 32%, #435487 61%, #85A1D5 100%);
		border-color: #212D3F;
		border-width: 0 0px 1px 0;
		border-style: solid;
		text-align: left;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
		padding: 4px 0;
		color: #000000;
		background: none;
		border-color: #2C365F;
		border-width: 0 0px 1px 0;
		border-style: solid;
		text-align: left;
	}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
		padding: 0 0 0 5px;
		overflow: hidden;
		word-break: break-all;
		white-space: normal;
		font-size: inherit;
		line-height: 24px;
		text-overflow: ellipsis;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
		border: 0px solid #8B2121;
		cursor: pointer;
		padding: 0 3px;
		margin: 4px;
		color: #2C365E;
		font-weight: 400;
		font-size: 14px;
		border-radius: 6px;
		outline: none;
		background: none;
		width: auto;
		height: 36px;
		order: 3;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
		opacity: 0.8;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
		border: 0px solid #8B2121;
		cursor: pointer;
		padding: 0 3px;
		margin: 4px;
		color: #2C365E;
		font-weight: 400;
		font-size: 14px;
		border-radius: 6px;
		outline: none;
		background: none;
		width: auto;
		height: 36px;
		order: 3;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
		opacity: 0.8;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
		border: 0px solid #8B2121;
		cursor: pointer;
		padding: 0 3px;
		margin: 4px;
		color: #2C365E;
		font-weight: 400;
		font-size: 14px;
		border-radius: 6px;
		outline: none;
		background: none;
		width: auto;
		height: 36px;
		order: 3;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
		opacity: 0.8;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
		border: 0px solid #8B2121;
		cursor: pointer;
		padding: 0 3px;
		margin: 4px;
		color: #2C365E;
		font-weight: 400;
		font-size: 14px;
		border-radius: 6px;
		outline: none;
		background: none;
		width: auto;
		height: 36px;
		order: 3;
	}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
		opacity: 0.8;
	}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
		margin: 0 20px 0 0;
		color: #333333;
		font-weight: 600;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
	}
	
	.main-content .el-pagination /deep/ .btn-prev {
		border: 1px solid #2C365F;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #2C365F;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		border-radius: 8px  8px  8px  8px;
		background: none;
		width: 40px;
		height: 40px;
		order: 2;
	}
	
	.main-content .el-pagination /deep/ .btn-next {
		border: 1px solid #2C365F;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #2C365F;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		border-radius: 8px  8px  8px  8px;
		background: none;
		width: 40px;
		height: 40px;
		order: 2;
	}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
		border: 1px solid #2C365F;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #2C365F;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		border-radius: 8px  8px  8px  8px;
		background: none;
		width: 40px;
		height: 40px;
		order: 2;
	}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
		border: 1px solid #2C365F;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #2C365F;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		border-radius: 8px  8px  8px  8px;
		background: none;
		width: 40px;
		height: 40px;
		order: 2;
	}

	.main-content .el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
		order: 2;
	}

	.main-content .el-pagination /deep/ .el-pager .number {
		border: 1px solid #2C365F;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #333333;
		font-weight: 600;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		line-height: 40px;
		border-radius: 8px  8px  8px  8px;
		background: none;
		width: 40px;
		height: 40px;
	}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
		border: 0px solid #333333;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		line-height: 40px;
		border-radius: 8px  8px  8px  8px;
		background: #2C365F;
		width: 40px;
		height: 40px;
	}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
		border: 0px solid #333333;
		cursor: not-allowed;
		padding: 0;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		line-height: 40px;
		border-radius: 8px  8px  8px  8px;
		background: #2C365F;
		width: 40px;
		height: 40px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		order: 1;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 1px solid #2C365F;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #333333;
		font-weight: 600;
		display: inline-block;
		font-size: 15px;
		line-height: 40px;
		border-radius: 3px;
		outline: 0;
		background: none;
		width: 100%;
		text-align: center;
		height: 40px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #fff;
		width: 25px;
		font-size: 15px;
		line-height: 28px;
		text-align: center;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #333333;
		display: inline-block;
		vertical-align: top;
		font-size: 15px;
		line-height: 40px;
		height: 40px;
		order: 3;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 15px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #2C365F;
		cursor: pointer;
		padding: 0 3px;
		color: #333333;
		font-weight: 600;
		display: inline-block;
		font-size: 15px;
		line-height: 40px;
		border-radius: 8px;
		outline: 0;
		background: none;
		width: 100%;
		text-align: center;
		height: 40px;
	}
	
	// list one
	.one .list1-view {
		border: 0;
		cursor: pointer;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0 5px 5px 0;
		outline: none;
		color: #fff;
		background: #481AD9;
		width: auto;
		font-size: 14px;
		min-width: 60px;
		height: 32px;
	}
	
	.one .list1-view:hover {
		opacity: 0.8;
	}
	
	.one .list1-edit {
		border: 0;
		cursor: pointer;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0 5px 5px 0;
		outline: none;
		color: #fff;
		background: #339933;
		width: auto;
		font-size: 14px;
		min-width: 60px;
		height: 32px;
	}
	
	.one .list1-edit:hover {
		opacity: 0.8;
	}
	
	.one .list1-del {
		border: 0;
		cursor: pointer;
		border-radius: 30px;
		padding: 0 10px;
		margin: 0 5px 5px 0;
		outline: none;
		color: #fff;
		background: #f00;
		width: auto;
		font-size: 14px;
		min-width: 60px;
		height: 32px;
	}
	
	.one .list1-del:hover {
		opacity: 0.8;
	}
	
	.one .list1-btn8 {
		border: 0;
		cursor: pointer;
		padding: 0 10px;
		margin: 0 5px 5px 0;
		color: #fff;
		font-size: 14px;
		border-radius: 30px;
		outline: none;
		background: #333;
		width: auto;
		min-width: 60px;
		height: 32px;
		order: 11;
	}
	
	.one .list1-btn8:hover {
		opacity: 0.8;
	}
	
	.main-content .el-table .el-switch {
		display: inline-flex;
		vertical-align: middle;
		line-height: 30px;
		position: relative;
		align-items: center;
		height: 30px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
		cursor: pointer;
		margin: 0 10px 0 0;
		color: #333;
		font-weight: 500;
		display: none;
		vertical-align: middle;
		font-size: 16px;
		transition: .2s;
		height: 30px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
		cursor: pointer;
		margin: 0 0 0 10px;
		color: #333;
		font-weight: 500;
		display: none;
		vertical-align: middle;
		font-size: 16px;
		transition: .2s;
		height: 30px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
		border: 1px solid #000;
		cursor: pointer;
		border-radius: 15px;
		margin: 0;
		outline: 0;
		background: #000;
		display: inline-block;
		width: 36px;
		box-sizing: border-box;
		transition: border-color .3s,background-color .3s;
		height: 18px;
	}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
		border-radius: 100%;
		top: 1px;
		left: 2px;
		background: #FFF;
		width: 14px;
		position: absolute;
		transition: all .3s;
		height: 14px;
	}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
		margin: 0 0 0 -16px;
		left: 100%;
	}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
		cursor: pointer;
		display: inline-block;
		vertical-align: middle;
		font-size: 0;
		position: relative;
	}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
		margin: 0 3px;
		display: inline-block;
		font-size: 18px;
		position: relative;
		transition: .3s;
	}

	.chartDialog /deep/ .el-dialog {
		background: #FFFFFF;
	}
	// echarts1
	.statShow1 {
		padding: 0;
		align-content: flex-start;
		background: none;
		display: flex;
		width: 100%;
		justify-content: space-between;
		flex-wrap: wrap;
		height: auto;
		.echarts1 {
			border-radius: 36px 0px 36px 0px;
			padding: 20px;
			margin: 10px;
			background: #C2D7F2;
			width: 100%;
			transition: 0.3s;
			height: 400px;
		}
		.echarts1:hover {
			transform: translate3d(0, -6px, 0);
			z-index: 1;
		}
	}
</style>
