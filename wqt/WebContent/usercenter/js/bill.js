var reg=/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/;
//弹出层 num:icon图片—6成功5失败   msg：错误提示
function comfirm_add(num,msg){
    layui.use('layer',function(){
        var layer=layui.layer;
        layer.open(
            {
                type:0,
                title:false,
                icon:num,
                content:msg,
                skin:"layui-layer-lan",
                btn:false,
                closeBtn:0,
                shade:0.5,
                shadeClose:true,
                time:1500,
                anim:1
            }
        )
    })
};
$.ajax({
    type:'post',
    url:wqturl+'/getProvince.action',
    dataType:'json',
    data:{},
    success:function(data){
        var province='<option>请选择省份</option>';
        for(var i=0;i<data.length;i++){
            province+='<option value='+data[i].id+'>'+data[i].provincename+'</option>'
        }
        $('#province').html(province);
    },
    error:function(){
        console.log('error');
    }
});
//监听省份框
$('#province').on('change',function(){
    var index = this.selectedIndex;
    var pid=$("#province option").eq(index).val();
    $.ajax({
        type:'post',
        url:wqturl+'/getCity.action',
        dataType:'json',
        data:{
            'provinceid':pid
        },
        error:function(XmlHttpRequest,textStatus,errorThrown){
            console.log(XmlHttpRequest.status);
        },
        success:function(data){
            var city='<option>请选择市级</option>';
            for(var i=0;i<data.length;i++){
                city+='<option value='+data[i].id+'>'+data[i].cityname+'</option>'
            }
            $("#city").html(city);
        }
    });
});
$(
  $("#need_p").click(function(){
      $(".bill_tab").hide();
      $(".bill_cont").show();
  }),
  $(".qx_kp_btn").click(function(){
      $(".bill_tab").show();
      $(".bill_cont").hide();
  }),
  $('.now_kp_btn').click(function(){
      var kind=$('#bill_kind option:checked').val(),
          billtitle=$('#bill_bagin').val(),
          provinceid=$('#province option:checked').val(),
          cityid=$('#city option:checked').val(),
          recvaddr=$('.detail_address').val(),
          recvname=$('#s_name').val(),
          recvmobile=$('#s_phone').val(),
          orderid=$("input[name='radioname']:checked").attr('data-id'),
          billmoney=$("input[name='radioname']:checked").attr('data-mon');
      if(orderid==null){
          comfirm_add(5,'请选择需要开发票的商品订单');
      }else if(kind=='请选择开票类型'){
          comfirm_add(5,'请选择开票类型');
      }else if(billtitle==''){
          comfirm_add(5,'发票开头');
      }else if(provinceid=='请选择省份'){
          comfirm_add(5,'请选择省份');
      }else if(cityid=='请选择市区'){
          comfirm_add(5,'请选择市区');
      }else if(recvaddr==''){
          comfirm_add(5,'请填写详细地址');
      }else if(recvname==''){
          comfirm_add(5,'请填写联系人姓名');
      }else if(recvmobile==''){
          comfirm_add(5,'请填写联系人电话');
      }else if(!reg.test(recvmobile)){
          comfirm_add(5,'请填写正确的联系电话');
      }else{
          $.ajax({
              type:'post',
              url:wqturl+'/saveUserBill.action',
              dataType:'json',
              data:{
                  'userBill.kind':kind,
                  'userBill.billtitle':billtitle,
                  'userBill.provinceid':provinceid,
                  'userBill.cityid':cityid,
                  'userBill.recvaddr':recvaddr,
                  'userBill.recvname':recvname,
                  'userBill.recvmobile':recvmobile,
                  'userBill.orderid':orderid,
                  'userBill.billmoney':billmoney
              },
              success:function(data){
                  if(data.result==1){
                      alert(data.msg);
                      window.location.reload();
                  }
              },
              error:function(error){
                  console.log(error)
              }
          })
      }
  })
);