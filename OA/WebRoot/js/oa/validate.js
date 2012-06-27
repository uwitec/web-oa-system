//�ַ�����;
//ȥ���ҿո�;
function trim(s){
     return rtrim(ltrim(s));
}
//ȥ��ո�;
function ltrim(s){
     return s.replace( /^\s*/, "");
}
//ȥ�ҿո�;
function rtrim(s){
     return s.replace( /\s*$/, "");
}
//����HTML�ַ�
function HTML(text){
    text = text.replace(/&/g, "&");
//    text = text.replace(/"/g, """);
    text = text.replace(/</g, "<");
    text = text.replace(/>/g, ">");
    text = text.replace(/'/g, "��");
    return text ;
}
//��ԭHTML�ַ�
function ReHTML(text){
    text = text.replace(/&/g, "&");
//    text = text.replace(/"/g, '"');
//    text = text.replace(/</g, "<");
    text = text.replace(/>/g, ">");
    text = text.replace(/��/g, "'");
    return text ;
}
// �ж���Ӣ�Ļ���ʱ��ĳ���
function byteLength (sStr) {
    aMatch = sStr.match(/[^\x00-\x80]/g);
    return (sStr.length + (! aMatch ? 0 : aMatch.length));
}

//��֤��Ϣ;
//���ַ�ֵ;
function isEmpty(s){
    s = trim(s);
    return s.length == 0;
}
//Email;
function isEmail(s){
    s = trim(s);
     var p = /^[_\.0-9a-z-]+@([0-9a-z][0-9a-z-]+\.){1,4}[a-z]{2,3}$/i;
     return p.test(s);
}
//����;
function isNumber(s){
    return !isNaN(s);
}
//��ɫֵ;
function isColor(s){
    s = trim(s);
    if (s.length !=7) return false;
    return s.search(/\#[a-fA-F0-9]{6}/) != -1;
}
//�ֻ�����;
function isMobile(s){
    s = trim(s);
    var p = /^1[3|4|5|8][0-9]\d{4,8}$/;
    return p.test(s);
}
//���֤;
function isCard(s){
    s = trim(s);
    var p = /^\d{15}(\d{2}[xX0-9])?$/;
    return p.test(s);
}
//URL;
function isURL(s){
    s = trim(s).toLowerCase();
    var p = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
    return p.test(s);
}
//Phone;
function isPhone(s){
    s = trim(s);
    var p = /^[0-9]{8,15}$/; 
    return p.test(s);
}
//Zip;
function isZip(s){
    s = trim(s);
    var p = /^[1-9]\d{5}$/;
    return p.test(s);
}
//Double;
function isDouble(s){
    s = trim(s);
    var p = /^[-\+]?\d+(\.\d+)?$/;
    return p.test(s);
}
//Integer;
function isInteger(s){
    s = trim(s);
    var p = /^[-\+]?\d+$/;
    return p.test(s);
}
//English;
function isEnglish(s){
    s = trim(s);
    var p = /^[A-Za-z]+$/;
    return p.test(s);
}
//����;
function isChinese(s){
    s = trim(s);
    var p = /^[\u0391-\uFFE5]+$/;
    return p.test(s);
}
//˫�ֽ�
function isDoubleChar(s){
    var p = /^[^\x00-\xff]+$/;
    return p.test(s);
}
//���������ַ�
function hasChineseChar(s){
    var p = /[^\x00-\xff]/;
    return p.test(s);
}
//15λ������ĸ�����֣��»���
function hasAccountChar(s){
    var p = /^[a-zA-Z0-9][a-zA-Z0-9_-]{0,15}$/;
    return p.test(s);
}
//�޶�����
function limitLen(s,Min,Max){
    s=trim(s);
    if(s=="") return false;
    if((s.length<Min)||(s.length>Max))
        return false;
    else
        return true;
}

