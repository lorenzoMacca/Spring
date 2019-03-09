
function BasicChart() {
    return {
        selector: null,
        columns: null,
        minY: null,
        maxY: null,
        custom_categories: new Array(),
        label: false,
        titleCallback: null,
        zoom: false,
        toolTipValueCallback: null,
        data:new Array(),
        yAxis : true,
        xAxis : true,

        showYAxis : function(v){
        	this.yAxis = v;
        	return this;
        },
        showXAxis : function(v){
        	this.xAxis = v;
        	return this;
        },
        withSelector: function (v) {
            this.selector = v;
            return this;
        },
        withColumns: function (v) {
            this.columns = v;
            return this;
        },
        withMinY: function (v) {
            this.minY = v;
            return this;
        },
        withMaxY: function (v) {
            this.maxY = v;
            return this;
        },
        withCategories: function (v) {
            this.custom_categories = v;
            return this;
        },
        activeLabel: function (v) {
            this.label = v;
            return this;
        },
        withTitleCallback: function (v) {
            this.titleCallback = v;
            return this;
        },
        withValueCallback: function(v){
        	this.toolTipValueCallback = v;
        	return this;
        },
        activeZoom: function (v) {
            this.zoom = v;
            return this;
        },
        withData: function(v){
        	this.data = v;
        	return this;
        },
        generateChart: function () {
            return c3.generate({
                bindto: this.selector,
                data: {
                    columns: [this.columns],
                    labels: this.label
                },
                axis: {
                    y: {
                        max: this.maxY,
                        min: this.minY,
                        show: this.yAxis
                    },
                    x: {
                        type: 'category',
                        categories: this.custom_categories,
                        show: this.xAxis
                    }
                },
                zoom: {
                    enabled: this.zoom
                },
                tooltip: {
                    format: {
                        title: this.titleCallback,
                        value: this.toolTipValueCallback
                    }
                }
            });
        }

    }
}