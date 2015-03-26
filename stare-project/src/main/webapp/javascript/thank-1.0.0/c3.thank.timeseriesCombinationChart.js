// Neet include c3.thank.charBase.js.
//param = {
//	"bindto" : "#closingConditionChart",
//	data : {
//		xFormat : "%Y/%m/%d",
//		names : {
//			data1 : 'Closing Price',
//			data2 : 'Money Amount'
//		},
//		"rows" : [ 
//			[ 'x', 'data1', 'data2' ], 
//			[ '2013/01/02', 10, 120 ],
//			[ '2014/01/03', 40, 160 ], 
//		],
//		types : {
//			data2 : 'bar'
//		},
//		axes : {
//			data2 : 'y2'
//		}
//	}
//}
function timeseriesCombinationChart(param) {

	function getDataTypes(param) {
		var data = getData(param);
		return data.types || {};
	}

	function getDataAxes(param) {
		var data = getData(param);
		return data.axes || {};
	}

	var chart = c3.generate({
		bindto : getBindto(param),
		data : {
			x : 'x',
			xFormat : getDataXFormat(param),
			names : getDataNames(param),
			rows : getDataRows(param),
			hide : getDataHide(param),
			types : getDataTypes(param),
			axes : getDataAxes(param)
		},
		axis : {
			x : {
				type : 'timeseries',
				tick : {
					format : getAxisXTickFormat(param),
					culling : {
						max : getAxisXTickCullingMax(param)
					}
				},
			},
			y2 : {
				show : true
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
