window.addEventListener('load',function(){
	var urlDiscoverpre  = "https://api.themoviedb.org/3/discover/movie";
	var apiKey          = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
	var language        = "&language=en-US";
	var urlDiscoverpost = "&sort_by=popularity.desc&include_adult=false&include_video=false&year=2019&page=";
	var urlDetailpre    = "https://api.themoviedb.org/3/movie/";
	var page = 1;
	document.querySelector('button#next').addEventListener('click',function(){
		const req = new XMLHttpRequest();
		req.open('GET', urlDiscoverpre+apiKey+language+urlDiscoverpost+page);
		req.send();
		req.onreadystatechange = function(event){
			if(	req.readyState ==4){
				if (req.status === 200) {
				 JSON.parse(req.response).results.map(
			        		(element,i)=>{
			        			$('#root').append($(`<div class="col s12 m6 l4">
												      <div class="card">
												        <div class="card-image">
												          <img src="https://image.tmdb.org/t/p/w500`+element.poster_path+`">
												          <span class="card-title">`+element.title+`</span>
												        </div>
												        <div class="card-content">`+element.overview+`.</p>
												        </div>
												        <div class="card-action">
												          <a idpage="`+element.id+`" class="liensDetail">This is a link</a>
												        </div>
												      </div>
												    </div>`));
			        		}
			        		);
				} else {
				    console.log("Status de la réponse: %d (%s)", req.status, req.statusText);
				}			}
		}
	});
});
