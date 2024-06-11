$.ajax({
    /* for line chart */
    url: `/linechartdata`,
    success: function(result){
        /* line chart single starts here */
        var category = JSON.parse(result).categories;
        var series = JSON.parse(result).series;
        var nam = JSON.parse(result).nam;
        drawLineChart(category, series, nam);
        /* line chart single ends here */
    },
    fail: function(result){
        console.log(result);
    }
});

/* for line chart */
function drawLineChart(category, series, nam){
    Highcharts.chart('chart', {
        chart: {
            type: 'line',
            width: 1100
        },

        title: {
            text: `Danh thu năm ${nam}`
        },

        xAxis: {
            categories: category
        },

        tooltip: {
            formatter: function() {
                return '<strong>'+this.x+': </strong>'+ this.y;
            }
        },

        series: [{
            data: series
        }]
    });
}
$('#years').change(function(){
    var nam = $('#years option:selected').val();
    getDoanhThu(nam);
});
function getDoanhThu(nam) {

    $.ajax({
        /* for line chart */
        url: `/linechartdata?nam=${nam}`,
        success: function(result){
            /* line chart single starts here */
            var category = JSON.parse(result).categories;
            var series = JSON.parse(result).series;
            var nam = JSON.parse(result).nam;
            drawLineChart(category, series, nam);
            /* line chart single ends here */
        },
        fail: function(result){
            console.log(result);
        }
    });

    /* for line chart */
    function drawLineChart(category, series, nam){
        Highcharts.chart('chart', {
            chart: {
                type: 'line',
                width: 1100
            },

            title: {
                text: `Danh thu năm ${nam}`
            },

            xAxis: {
                categories: category
            },

            tooltip: {
                formatter: function() {
                    return '<strong>'+this.x+': </strong>'+ this.y;
                }
            },

            series: [{
                data: series
            }]
        });
    }

}
