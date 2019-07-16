var url=window.location.href.split('?')[1],
    uu=$('.has_btn').attr('href');
$(
    $('.has_btn').attr('href',uu+url)
);