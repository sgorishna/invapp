function searchByAccountNumber()
{
var xmlhttp;
var k=document.getElementById("searchByAccountNumber").value;

var urls="searchByAccountNumber?accountNumber="+k;
 
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4)
    {
      
        document.getElementById("searchByAccountNumberList").innerHTML=xmlhttp.responseText;
 
    }
  };
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}