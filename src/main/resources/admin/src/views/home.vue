<template>
	<div class="home-content" :style="{'backgroundImage': indexBgUrl?`url(${$base.url + indexBgUrl})`:''}">
		<!-- title -->
		<div id="home-title" class="home-title animate__animated">
			<div class="titles" >
				<span>Welcome使用</span>
				{{this.$project.projectName}}
			</div>
		</div>
		<!-- statis -->
		<div class="statis-box">
			<div id="statis1" class="statis1 animate__animated" v-if="isAuth('shebeixinxi','Homepage总数')">
				<div class="left">
					<span class="icon iconfont icon-liulan12"></span>
				</div>
				<div class="right">
					<div class="num">{{shebeixinxiCount}}</div>
					<div class="name">Total Equipment Count</div>
				</div>
			</div>
			<div id="statis2" class="statis2 animate__animated" v-if="isAuth('jiechushebei','Homepage总数')">
				<div class="left">
					<span class="icon iconfont icon-liulan12"></span>
				</div>
				<div class="right">
					<div class="num">{{jiechushebeiCount}}</div>
					<div class="name">Loan E-Total</div>
				</div>
			</div>
		</div>
		<!-- statis -->
	
		<!-- echarts -->
		<!-- 2 -->
		<div class="type2">
			<div class="echarts1 animate__animated" v-if="isAuth('shebeixinxi','Homepage统计',2)">
				<div id="shebeixinxiChart1" style="width: 100%;height: 100%"></div>
			</div>
			<div class="echarts2 animate__animated" v-if="isAuth('jiechushebei','Homepage统计',2)">
				<div id="jiechushebeiChart1" style="width: 100%;height: 100%"></div>
			</div>
		</div>
		<!-- echarts -->
	</div>
</template>
<script>
import 'animate.css'
//2
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			shebeixinxiCount: 0,
			jiechushebeiCount: 0,
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#698AE5","#2A345B","#A4D348","#4FB7F1","#2CD89E","#89e6d8","#4495ac","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"animationDuration":6000,"symbol":"image://http://codegen.caihongy.cn/20251017/1c88d9cb94ce458fb6e481abb0d74998.png","label":{"color":"#725BFF","show":false,"position":"top"},"symbolSize":[20,15],"symbolOffset":[0,1],"animation":true},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":30,"padding":0,"shadowOffsetX":0,"margin":10,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"truncate","borderRadius":0,"borderWidth":0,"width":120,"interval":0,"fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"minInterval":1,"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"grid":{"right":"20","top":"60","left":"20","bottom":"20","containLabel":true},"series":{"barWidth":"12px","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#f2f8d4","shadowOffsetY":0,"color":{"x":0,"y":0,"y2":1,"x2":0,"global":false,"colorStops":[{"offset":0,"color":"#2D3761"},{"offset":1,"color":"#698AE5"}],"type":"linear"},"shadowBlur":0,"borderWidth":0,"barBorderRadius":[24,24,0,0],"opacity":1,"shadowColor":"#000"},"colorBy":"data","label":{"formatter":"","show":true,"position":"top"},"barCategoryGap":"30%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"subtext":"","shadowBlur":0,"bottom":"auto","show":true,"right":"auto","subtextStyle":{"padding":[5,0,0,0],"borderColor":"red","color":"red","borderWidth":10},"top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
			pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"title":{"borderType":"solid","padding":[5,0,0,0],"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":[5,0,0,0],"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":0,"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#8838FF"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#666","color":"inherit","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#666","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#8838FF","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#8838FF"},"length2":14,"smooth":false}}},
			funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"center","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			boardBase: {"funnelNum":8,"lineNum":8,"radarNum":8,"gaugeNum":8,"barNum":8,"pieNum":8},
			gauge: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#333"}},"backgroundColor":"transparent","color":["#698AE5","#2A345B","#A4D348","#BD8CE8","#C500FF","#FD0B6A","#9ADBC4","#FFAA00","#000000"],"title":{"top":"top","left":"left","textStyle":{"fontSize":14,"lineHeight":24,"color":"#333","fontWeight":600}},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":25,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":3,"width":20,"fontSize":12,"height":10},"title":{"fontSize":14},"animation":true}},
			radar: {"backgroundColor":"transparent","radar":{"shape":"circle"},"color":["#698AE5","#2A345B","#A4D348","#7690cb","#49ada0","#5BBAEC","#a68a28","#EE142F","#FFE9E9"],"legend":{"padding":5,"itemGap":5,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":4,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":4,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#333"}},"title":{"top":"top","left":"left","textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":14,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0}}},
			indexBgUrl: '',
			indexLogoUrl: '',
		};
	},
	mounted(){
		this.init();
		this.getshebeixinxiCount();
		if(this.isAuth('shebeixinxi','Homepage统计',2)){
			this.shebeixinxiChat1();
		}
		this.getjiechushebeiCount();
		if(this.isAuth('jiechushebei','Homepage统计',2)){
			this.jiechushebeiChat1();
		}
		window.addEventListener('scroll', this.handleScroll)
		setTimeout(()=>{
			this.handleScroll()
		},100)
	},
	created() {
		this.$http.get('config/info?name=bIndexBackgroundImg',).then(rs=>{this.indexBgUrl = rs.data.data?rs.data.data.value:''})
		this.$http.get('config/info?name=bHomeLogo',).then(rs=>{this.indexLogoUrl = rs.data.data?rs.data.data.value:''})
	},
	computed: {
		sessionForm() {
			return JSON.parse(this.$storage.getObj('userForm'))
		},
		avatar(){
			return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
		},
	},
	methods:{
		handleScroll() {
			let arr = [
				{id:'home-title',css:'animate__'},
				{id:'statis1',css:'animate__'},
				{id:'statis2',css:'animate__'},
				{id:'shebeixinxiChart1',css:'animate__'},
				{id:'jiechushebeiChart1',css:'animate__'},
			]
			
			for (let i in arr) {
				let doc = document.getElementById(arr[i].id)
				if (doc) {
					let top = doc.offsetTop
					let win_top = window.innerHeight + window.pageYOffset
					// console.log(top,win_top)
					if (win_top > top && doc.classList.value.indexOf(arr[i].css) < 0) {
						// console.log(doc)
						doc.classList.add(arr[i].css)
					}
				}
			}
		},
		// 统计图动画
		myChartInterval(type, xAxisData, seriesData, myChart) {
			this.$nextTick(() => {
				setInterval(() => {
					let xAxis = xAxisData.shift()
					xAxisData.push(xAxis)
					let series = seriesData.shift()
					seriesData.push(series)
				
					if (type == 1) {
						myChart.setOption({
							xAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
					if (type == 2) {
						myChart.setOption({
							yAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
				}, $template2.back.board.bar.base.interval);
			})
		},
		changeStatQuery(arr) {
			if(arr.length==1) {
				if(arr[0] == 'users'&&this.$storage.get("sessionTable")=='users') {
					return true
				}
			}
			let role = this.$storage.get('role')
			for(let x in arr) {
				if(arr[x] == role) {
					return true
				}
			}
			return false
		},
		init(){
			if(this.$storage.get('Token')){
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code != 0) {
						router.push({ name: 'login' })
					}
				});
			}else{
				router.push({ name: 'login' })
			}
		},
		getshebeixinxiCount() {
			this.$http({
				url: `shebeixinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.shebeixinxiCount = data.data
				}
			})
		},
		shebeixinxiChat1(e=null) {
			this.$nextTick(()=>{
				var shebeixinxiChart1 = echarts.init(document.getElementById("shebeixinxiChart1"),'macarons');
				let params = {}
				this.$http({
					url: `shebeixinxi/valueMul/shebeimingcheng?yColumnNameMul=shebeizongshu,jiechushuliang,keyongshuliang`,
					method: "get",
					params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis1 = [];
						let yAxis1 = [];
						let pArray1 = []
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
						let pArray2 = []
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
						let pArray3 = []
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
						titleObj.text = 'Inventory Statistics'
						
						const legendObj = this.line.legend
						legendObj.data = [
							'E-Total'.split('/').length>1?'E-Total'.split('/')[0]:'E-Total',
							'Loan-Num'.split('/').length>1?'Loan-Num'.split('/')[0]:'Loan-Num',
							'Available'.split('/').length>1?'Available'.split('/')[0]:'Available',
						]
				
						let xAxisObj = this.line.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis1
						
						let yAxisObj = this.line.yAxis
						yAxisObj.type = 'value'
						
						let seriesObj = [
							{
								data: yAxis1,
								type: 'E-Total'.split('/').length>1?'E-Total'.split('/')[1]:'line',
								name: 'E-Total'.split('/').length>1?'E-Total'.split('/')[0]:'E-Total',
							},
							{
								data: yAxis2,
								type: 'Loan-Num'.split('/').length>1?'Loan-Num'.split('/')[1]:'line',
								name: 'Loan-Num'.split('/').length>1?'Loan-Num'.split('/')[0]:'Loan-Num',
							},
							{
								data: yAxis3,
								type: 'Available'.split('/').length>1?'Available'.split('/')[1]:'line',
								name: 'Available'.split('/').length>1?'Available'.split('/')[0]:'Available',
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
						shebeixinxiChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							shebeixinxiChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


		getjiechushebeiCount() {
			this.$http({
				url: `jiechushebei/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.jiechushebeiCount = data.data
				}
			})
		},
		jiechushebeiChat1(e=null) {
			this.$nextTick(()=>{
				var jiechushebeiChart1 = echarts.init(document.getElementById("jiechushebeiChart1"),'macarons');
				let params = {}
				if(params.conditionColumn) {
					params.conditionColumn += ';' + 'sfsh'
					params.conditionValue += ';' + '是'
				}else {
					params.conditionColumn = 'sfsh'
					params.conditionValue = '是'
				}
				this.$http({
					url: `jiechushebei/value/shebeimingcheng/keyongshuliang`,
					method: "get",
					params
				}).then(({ data }) => {
					if (data && data.code === 0) {
						let res = data.data;
						let xAxis = [];
						let yAxis = [];
						let pArray = []
						for(let i=0;i<res.length;i++){
							if(this.boardBase&&i==this.boardBase.barNum){
								break;
							}
							xAxis.push(res[i].shebeimingcheng);
							yAxis.push(parseFloat((res[i].total)));
							pArray.push({
								value: parseFloat((res[i].total)),
								name: res[i].shebeimingcheng
							})
						}
						var option = {};
						let titleObj = this.bar.title
						titleObj.text = 'Borrow Statistics'
						
						const legendObj = this.bar.legend
						let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
						tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
						let xAxisObj = this.bar.xAxis
						xAxisObj.type = 'category'
						xAxisObj.data = xAxis
						
						let yAxisObj = this.bar.yAxis
						yAxisObj.type = 'value'
						let seriesObj = {
							data: yAxis,
							type: 'bar',
						}
						seriesObj = Object.assign(seriesObj , this.bar.series)
						const gridObj = this.bar.grid
						
						option = {
							backgroundColor: this.bar.backgroundColor,
							color: this.bar.color,
							title: titleObj,
							legend: legendObj,
							grid: gridObj,
							tooltip: tooltipObj,
							xAxis: xAxisObj,
							yAxis: yAxisObj,
							series: [seriesObj]
						};
						// 使用刚指定的配置项和数据显示图表。
						jiechushebeiChart1.setOption(option);
				
						//根据窗口的大小变动图表
						window.onresize = function() {
							jiechushebeiChart1.resize();
						};
					}else{
						this.$message({
							message: data.msg,
							type: "warning",
							duration: 1500,
						})
					}
				});
			})
		},


	}
};
</script>
<style lang="scss" scoped>
	.home-content {
		padding: 0 30px 30px 20px ;
		background: url(http://codegen.caihongy.cn/20251011/76e798ec7ea148e2a8763180b7ccc382.png) no-repeat center center / 100% 100%;
		display: flex;
		width: 100%;
		min-height: 100vh;
		flex-wrap: wrap;
		.home-title {
			padding: 10px 0 0;
			box-shadow: none;
			margin: 10px 0 0;
			display: none;
			width: 100%;
			justify-content: center;
			align-items: center;
			transition: 0.3s;
			.titles {
				padding: 0;
				color: #333;
				font-size: 30px;
				line-height: 60px;
				span {
				}
			}
		}
		.home-title:hover {
			transform: translate3d(0, 0px, 0);
		}
		.statis-box {
			margin: 20px 0;
			background: none;
			display: flex;
			width: 100%;
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.statis1 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis1:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis2 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis2:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis3 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis3:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis4 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis4:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis5 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis5:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis6 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis6:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis7 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis7:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis8 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis8:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis9 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis9:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
			.statis10 {
				border:  1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 25px 0;
				margin: 10px;
				color: #fff;
				background:  linear-gradient( 180deg, #99B4EB 0%, #2C3C6F 100%);
				display: flex;
				width: calc(18% - 20px);
				align-items: center;
				transition: 0.3s;
				height: auto;
				.left {
					margin: 50px 0 0 0;
					background: url(http://codegen.caihongy.cn/20250909/479f76ed133f4229b74525607d190cd9.png) no-repeat center center / 100% 100%;
					display: none;
					width: 84px;
					justify-content: center;
					align-items: center;
					height: 64px;
					order: 2;
					.iconfont {
						border-radius: 0;
						padding: 0;
						color: #599BFF;
						background: none;
						font-weight: bold;
						display: none;
						width: 48px;
						font-size: 32px;
						line-height: 40px;
						text-align: center;
						height: 40px;
					}
				}
				.right {
					display: flex;
					flex-wrap: wrap;
					.num {
						color: inherit;
						font-weight: bold;
						display: flex;
						width: 100%;
						font-size: 45px;
						justify-content: center;
						order: 2;
					}
					.name {
						color: inherit;
						font-weight: 400;
						display: flex;
						width: 100%;
						font-size: 16px;
						justify-content: center;
					}
				}
			}
			.statis10:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
				color: #2A345B;
				background: linear-gradient( 180deg, #D1E8C0 0%, #A4D348 100%);
			}
		}
		// echarts2
		.type2 {
			padding: 0;
			align-content: flex-start;
			background: none;
			display: flex;
			width: 100%;
			justify-content: space-between;
			flex-wrap: wrap;
			height: auto;
			.echarts1 {
				border: 1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 20px;
				margin: 10px;
				background: #C2D7F2;
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 400px;
			}
			.echarts1:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
			}
			.echarts2 {
				border: 1px solid #FFFFFF;
				border-radius: 36px 0px 36px 0px;
				padding: 20px;
				margin: 10px;
				background: #C2D7F2;
				width: calc(50% - 20px);
				transition: 0.3s;
				height: 400px;
			}
			.echarts2:hover {
				transform: translate3d(0, -6px, 0);
				z-index: 1;
			}
		}
	}
	
	.echarts-flag-2 {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		padding: 10px 20px;
		background: rebeccapurple;
	
		&>div {
			width: 32%;
			height: 300px;
			margin: 10px 0;
			background: rgba(255,255,255,.1);
			border-radius: 8px;
			padding: 10px 20px;
		}
	}
	.animate__animated {
		animation-fill-mode: none;
	}
</style>
