// Neet include c3.thank.charBase.js.
//param = {
//	bindto : "#monthlyOperatingIncomeChart",
//	data : {
//		xFormat : "%Y/%m",
//		names : {
//			data1 : 'Current Month" />',
//			data2 : 'Current Month Of LastYear" />'
//		},
//		rows : [ 
//		        	[ 'x', 'data1', 'data2' ], 
//		        	[ '2013/01', 10, 120 ],
//		        	[ '2014/01', 40, 160 ], 
//		       ],
//		hide : [ "data1" ]
//	},
//	axis : {
//		x : {
//			tick : {
//				format : "%Y/%m"
//			}
//		}
//	}
//}
function timeseriesAreaStepChart(param) {
	var chart = c3.generate({
		bindto : getBindto(param),
		data : {
			x : 'x',
			xFormat : getDataXFormat(param),
			names : getDataNames(param),
			rows : getDataRows(param),
			hide : getDataHide(param),
			type : 'area-step'
		},
		axis : {
			x : {
				type : 'timeseries',
				tick : {
					format : getAxisXTickFormat(param),
					culling : {
						max : getAxisXTickCullingMax(param)
					}
				}
			}
		},
		subchart : {
			show : getSubchartShow(param)
		},
		zoom : {
			rescale : getZoomRescale(param)
		},
		point : {
			show : getPointShow(param)
		}
	});
	return chart;
}
