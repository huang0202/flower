var App = function () {
    //选择出控制的checkbox
    var _masterCheckbox;
    //选出所有的chexkbox
    var _checkbox;

    /**
     * 私有方法，初始化 ICheck
     */
    var handlerInitCheckbox = function () {

        // 激活 iCheck
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        //选择出控制的checkbox
        var _masterCheckbox = $('input[type="checkbox"].icheck_master');
        //选出所有的chexkbox
        var _checkbox = $('input[type="checkbox"].minimal');
    }
    return {
        init: function () {
            handlerInitCheckbox();

        }
    }
}();
$(document).ready(function () {
    App.init();
});