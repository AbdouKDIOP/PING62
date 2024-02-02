$(document).ready(function() {
    $('.filter').keyup(function() {
        var index = $(this).data('column');
        var value = $(this).val().toLowerCase();
        $('#myTable tbody tr').filter(function() {
            return $('td', this).eq(index).text().toLowerCase().indexOf(value) > -1;
        }).show().not(this).hide();
    });
});
