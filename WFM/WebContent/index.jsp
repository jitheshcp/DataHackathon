<%@page contentType="text/html" pageEncoding="UTF-8"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>VDSI Hackathon - Sentiment Analysis</title> 
    </head> 

    <body>  
        <div> 
            <h3> Choose File to Upload </h3> 
            <form action="upload" method="post" enctype="multipart/form-data"> 
                <input type="file" name="file" /> 
                <input type="submit" value="upload" onclick="javascript: showHide()"/> 

            </form>           
        </div> 
        <div width="100%" id="chartDiv">
	        <table>
	        	<thead>
	        		<tr>
	        			<th>Pie Chart Report</th>
	        			<th>Bar Chart Report</th>
	        		</tr>
	        	</thead>
	        	<tbody>
	        		<tr>
	        		<td>
	        			<div>
				        	<img alt="" src="D://workspace/charts/pie.png" >
				        </div>
	        		</td>
	        		<td>
	        			<div>
				        	<img alt="" src="D://workspace/charts/bar.png" >
				        </div>
	        		</td>
	        	</tr>
	        	</tbody>
	        </table>
        </div>
<script type="text/javascript">
	function showHide(){
		alert("showHide");
		document.getElementById("chartDiv").show();
	}

</script>
</body> 
</html> 
