var byTimer = null;
function autoby(bj,size){
	var index=2;
	byTimer = setInterval(function(){
		bj.style.backgroundImage = "url(lovebiaobai/image/"+index+".jpg)";
		bj.style.backgroundSize = "100% 100%";
		index++;
		if(index>size)index=1;
	},3000);
}
