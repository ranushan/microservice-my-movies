$(document).ready(()=>{
    var urlDiscoverpre  = "https://api.themoviedb.org/3/discover/movie";
    var apiKey          = "?api_key=0a2eea61408ba5facdd057f7d11d2f58";
    var language        = "&language=en-US";
    var urlDiscoverpost = "&sort_by=popularity.desc&include_adult=false&include_video=false&year=2019&page=";
    var urlDetailpre    = "https://api.themoviedb.org/3/movie/";
    var page = 0;
    $('button#next').click(()=>{
        page++;
        $.ajax(urlDiscoverpre+apiKey+language+urlDiscoverpost+page).done(

            (d)=>{
                $('#root').html("");
                d.results.map(
                    (element,i)=>{
                        $('#root').append($(`<div class="col s6">
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
                $('.liensDetail').click(function(){
                    console.log(this)
                    let idpage = $(this).attr('idpage');
                    $.ajax(urlDetailpre+idpage+apiKey+language).done((t)=>{
                        console.log(d);
                        console.log("This : ", t);
                    })

                })


            }
        );
    })
    $('button#load').click(()=>{
        $.ajax(urlDiscoverpre+apiKey+language).done(
            (d)=>{
                d.results.map(
                    (element,i)=>{
                        $('#root').append($(`<div class="row">
										        <div class="col s12 m7">
											        <div class="card">
											            <div class="card-image">
											                <img src="https://image.tmdb.org/t/p/w500`+element.poster_path+`">
										                    <span class="card-title">Card Title</span>
										                </div>
											            <div class="card-content">
										                    <p>I am a very simple card. I am good at containing small bits of information.
												                I am convenient because I require little markup to use effectively.</p>
										                </div>
										                <div class="card-action">
										                    <a href="#">This is a link</a>
										                </div>
										            </div>
											    </div>
											 </div>`));
                    }
                );
            }
        );
    });

});