
function BasicChart() {
    return {
        selector: null,
        columns: null,
        minY: null,
        maxY: null,
        custom_categories: null,
        label: false,
        titleCallback: null,
        zoom: false,

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
        activeZoom: function (v) {
            this.zoom = v;
            return this;
        },
        generateChart: function () {
            var chart = c3.generate({
                bindto: this.selector,
                data: {
                    columns: [this.columns],
                    labels: this.label
                },
                axis: {
                    y: {
                        max: this.maxY,
                        min: this.minY,
                    },
                    x: {
                        type: 'category',
                        categories: this.custom_categories
                    }
                },
                zoom: {
                    enabled: this.zoom
                },
                tooltip: {
                    format: {
                        title: this.titleCallback
                    }
                }
            });
        }

    }
}