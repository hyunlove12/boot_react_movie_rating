import React, { useEffect, useState } from 'react'
import Axios from 'axios'
import Menu from "./../include/Menu.jsx"
import { withCookies, Cookies, ReactCookieProps } from 'react-cookie'

function LoginPage(props) {

	//Axios.setHeader('Content-Type', 'application/x-www-form-urlencoded', [
	//  'post'
	//])
	// const {cookies} = props
	
	// const [cookies, setCookies] = useState(props.cookies)
	// const csrfToken = cookies.get('XSRF-TOKEN')
	 
	const [Id, setId] = useState("") 
    const [PassWord, setPassWord] = useState("")
    
    useEffect(() => {
	   // if(cookies) {
	   //   const currentCookies = cookies.get('XSRF-TOKEN');
	
	    //  setShowPopUp(!currentCookies);
	    //  setHasCookies(!!currentCookies);
	    //} else {
	  //    setCookies(props.cookies)
	  //  }
    }, []);
  
    const variables = {
            username : Id,
            password : PassWord
    }
    
    const findPassWord = (e) => {
    	alert('비밀번호 찾기!')
    }
    
    const findId = (e) => {
    	alert('ID찾기!')
    }
    
    // const temp = `username=${Id}&password=${PassWord}`
	const config = { headers : {'Content-Type' : 'application/x-www-form-urlencoded'}}
	const onSubmit = (e) => {
        e.preventDefault()
        console.log(variables)
        
     //   Axios.post('/login', temp, config)
        Axios.post('/api/authentications', variables)
        	.then(res => {
        		console.log(res)
                console.log(res.data)
                if(res.status == 200 ) {
			        // 페이지 전화 후 데이터 다시 로드?
			        props.history.push(`/ratingmain`);
                    // setMovieList(res.data.movieList)
                } else {
                	alert('로그인에 실패했습니다.')
                } 
       	    })       	    
            .catch(function (error) {
           		alert('로그인에 실패했습니다.')
				console.log(error);
			})
    }
    
    
    const onPassWordChange = (e) => {        
        setPassWord(e.currentTarget.value)
    }
    const onIdChange = (e) => {        
        setId(e.currentTarget.value)
    }
    
return (
        <>
            <Menu />
            <main id="main">
                <div className="site-section pb-0 site-portfolio">                                        
                    <div className="container"> 
                        <div className="row mb-5 align-items-end">
                            <div className="col-md-6" data-aos="fade-up">
                                <h2>로그인</h2>
                                <p className="mb-0">ID와 비밀번호를 입력해 주세요</p>
                            </div>                    
                        </div>     
                                           
                        <div className="row">                   
                         
                            <div className="col-md-6 mb-5 mb-md-0" data-aos="fade-up">                    
                                <form onSubmit={onSubmit} role="form" className="php-email-form">                        
                                    <div className="row">
                                    	<div className="col-md-12 form-group">
                                            <label htmlFor="id">ID</label> <input type="text" name="id"
                                            className="form-control" id="id" data-rule="minlen:4"
                                            data-msg="Please enter at least 4 chars" onChange={onIdChange} value={Id} />
                                            <div className="validate"></div>
                                        </div>                                       
                                        <div className="col-md-12 form-group">
                                            <label htmlFor="name">비밀번호</label> <input type="password"
                                            className="form-control" id="subject"
                                            data-rule="minlen:4"
                                            data-msg="Please enter at least 8 chars of subject" onChange={onPassWordChange} value={PassWord} />
                                            <div className="validate"></div>
                                        </div> 
                                        <div className="col-md-6 form-group">
                                            <label htmlFor="checkDup">ID찾기</label> <input type="button" id="checkDup"
                                            className="form-control" onClick={findId} />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-6 form-group">
                                            <label htmlFor="checkDup">비밀번호 찾기</label> <input type="button" id="checkDup"
                                            className="form-control" onClick={findPassWord} />
                                            <div className="validate"></div>
                                        </div>                               
                                        <div className="col-md-12 mb-3">
                                            <div className="loading">Loading</div>
                                            <div className="error-message"></div>
                                            <div className="sent-message">Your message has been sent. Thank you!</div>
                                        </div>                                        
                                        <div className="col-md-6 form-group">
                                            <input type="submit" onClick={onSubmit} className="readmore d-block w-100" value="로그인" />
                                        </div>
                                    </div>                                
                                </form>                    
                            </div>
                        
                            <div className="col-md-4 ml-auto order-2" data-aos="fade-up">
                                <ul className="list-unstyled">
                                    <li className="mb-3"><strong className="d-block mb-1">로그인</strong>
                                        <span>로그인 페이지 입니다.</span>
                                    </li>						
                                    <li className="mb-3"><strong className="d-block mb-1">문의사항</strong>
                                        <span>youremail@domain.com</span>
                                    </li>
                                </ul>
                            </div>    
                                            
                        </div>                    
                    </div>                    
                </div>
            </main>
        </>
       )
}

export default LoginPage
