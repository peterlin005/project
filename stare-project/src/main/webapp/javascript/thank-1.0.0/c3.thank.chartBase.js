function getAxis(p) {
	return p.axis || {};
}
function getX(p) {
	return p.x || {};
}
function getTick(p) {
	return p.tick || {};
}
function getSubchart(p) {
	return p.subchart || {};
}
function getZoom(p) {
	return p.zoom || {};
}
function getPoint(p) {
	return p.point || {};
}
function getData(p) {
	return p.data || {};
}
function getCulling(p) {
	return p.culling || {};
}

function getBindto(param) {
	return param.bindto || "#chart";
}

function getDataRows(param) {
	var data = getData(param);
	return data.rows || [];
}

function getDataX(param) {
	var data = getData(param);
	return data.x || "x";
}

function getDataXFormat(param) {
	var data = getData(param);
	return data.xFormat || '%Y/%m/%d';
}

function getDataNames(param) {
	var obj = {};
	var data = getData(param);
	var names = data.names;
	for (key in names) {
		obj[key] = names[key];
	}
	return obj;
}

function getDataHide(param) {
	var data = getData(param);
	return data.hide || [];
}

function getDataGroups(param) {
	var data = getData(param);
	return data.groups || [];
}

function getAxisXTickFormat(param) {
	var axis = getAxis(param);
	var x = getX(axis);
	var tick = getTick(x);
	return tick.format || "%Y/%m/%d";
}

function getSubchartShow(param) {
	var subchart = getSubchart(param);
	return subchart.show || true;
}

function getPointShow(param) {
	var point = getPoint(param);
	return point.show || false;
}

function getZoomRescale(param) {
	var zoom = getZoom(param);
	return zoom.rescale || true;
}

function getAxisXTickCullingMax(param) {
	var axis = getAxis(param);
	var x = getX(axis);
	var tick = getTick(x);
	var culling = getCulling(tick);
	return culling.max || 3;
}