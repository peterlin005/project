// Neet include c3.thank.charBase.js.
//var param = {
//	"bindto" : "#balanceSheetChart",
//	data : {
//		names : {
//			data1 : 'Current Assets',
//			data2 : 'Noncurrent Assets',
//			data3 : 'Current Liabilities',
//			data4 : 'Noncurrent Liabilities',
//			data5 : 'Equity'
//		},
//		rows : [ [ 'x', 'data1', 'data2', 'data3', 'data4', 'data5' ],
//				[ '2013/01', 10, 120, 223, 42, 32 ],
//				[ '2014/01', 40, 160, 98, 32, 22 ], ]
//	}
//}
function timeseriesBarChart(param) {
	var chart = c3.generate({
		bindto : getBindto(param),
		data : {
			x : 'x',
			type : 'bar',
			xFormat : getDataXFormat(param),
			names : getDataNames(param),
			rows : getDataRows(param),
			hide : getDataHide(param),
			groups : getDataGroups(param)
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
		}
	});

	return chart;
}
