import React, { useEffect, useState, useRef } from 'react'
import Axios from 'axios'
import Menu from "./../include/Menu.jsx"
import "./../../css/star.css"

function RatingMain(props) {

    const [MovieList, setMovieList] = useState([])
    const spanRef = useRef(null)

    useEffect(() => {
        // 랜덤으로 영화 6개 받아오기
        Axios.get('/api/movie/ratingmovielist')
            .then(res => {
            	console.log(res.status)
            	setMovieList(res.data)
                if(res.data.success) {
                    setMovieList(res.data)
                } else {
                    alert('영화 정보를 가져오지 못했습니다.')
                }
            })
    } , [])

    const onSubmit = (e) => {
        e.preventDefault()
        Axios.post('/api/ratingmovie')
            .then(res => {
                if(res.data.success) {
                    setMovieList(res.data.movieList)
                } 
            })
        // 페이지 전화 후 데이터 다시 로드?
        // props.history.push(`/api/ratingmovie/${nextPostId}`);
    }
	
    const onSpanClick = (e) => {
        e.preventDefault()
        var idx = spanRef.index()
        // 인덱스는 0부터
        spanRef.parent('div').find(".star").removeClass("on")
            for(var i=0; i<=idx; i++){
            spanRef.parent('div').find(".star").eq(i).addClass("on")
        }
        var rating = idx / 2 + 0.5
        spanRef.parent('div').find('p > input[name="movierating"]').val(rating)
    }

    const renderMovieList = MovieList.map((movie, index) => {
		
        return (
            <div className="item web col-sm-6 col-md-4 col-lg-4 mb-4">
                <a className="item-wrap fancybox">
                    <div className="work-info">
                        <h3>{movie.title}</h3>
                        <div className="star-rating">
                            <span onClick={onSpanClick} className="star star_left"></span>
                            <span onClick={onSpanClick} className="star star_right"></span>

                            <span onClick={onSpanClick} className="star star_left"></span>
                            <span onClick={onSpanClick} className="star star_right"></span>

                            <span onClick={onSpanClick} className="star star_left"></span>
                            <span onClick={onSpanClick} className="star star_right"></span>

                            <span onClick={onSpanClick} className="star star_left"></span>
                            <span onClick={onSpanClick} className="star star_right"></span>

                            <span onClick={onSpanClick} className="star star_left"></span>
                            <span onClick={onSpanClick} className="star star_right"></span>

                            <p>
                                <input type="hidden" value='0' name="movierating" id="{movie.movieId}_movieid" />
                                <input type="hidden" name="movieid" value="{movie.movieId}" />
                            </p>
                        </div>
                    </div>                    
                    <img style={{width : '350px', height : '500px'}} className="img-fluid" src={`/movie_img/${movie.imgTitle}`} />
                </a>
            </div>
        )
    })

    return (
            <>
                <Menu />
                <main id="main">
                    <form action="/main" method="post" role="form">
                        <div className="site-section site-portfolio">
                            <div className="container">
                                <div className="row mb-5 align-items-center">
                                    <div className="col-md-12 col-lg-6 mb-4 mb-lg-0" data-aos="fade-up">
                                        <div className="row">
                                            <div className="col-md-6 form-group">
                                                <input type="submit" onClick={onSubmit} className="readmore d-block w-100" value="평점 입력 후 클릭하세요!" />
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div id="portfolio-grid" className="row no-gutter" data-aos="fade-up" data-aos-delay="200">

                                    {renderMovieList}

                                </div>
                            </div>
                        </div>
                    </form>
                </main>
            </>
           )
}

export default RatingMain
