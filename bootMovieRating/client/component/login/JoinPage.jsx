import React, { useEffect, useState } from 'react'
import Axios from 'axios'
import Menu from "./../include/Menu.jsx"
import { withCookies, Cookies, ReactCookieProps } from 'react-cookie'

function JoinPage(props) {
	
	// const {cookies} = props
	
	// const [cookies, setCookies] = useState(props.cookies)
	// const csrfToken = cookies.get('XSRF-TOKEN')
	 
	const [Id, setId] = useState("") 
	const [Name, setName] = useState("")
    const [Email, setEmail] = useState("")
    const [PassWord, setPassWord] = useState("")
    const [Message, setMessage] = useState("")
    
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
            name : Name,
            id : Id,
            email : Email,
            password : PassWord,
            message : Message
    }
    
    const checkDup = (e) => {
    	alert('중복체크 확인!')
    }
        
	const onSubmit = (e) => {
        e.preventDefault()
        console.log(variables)
        console.log(Id)
        console.log(Name)
        console.log(PassWord)
        
        Axios.post('/api/login/join', variables)
        	.then(res => {
                if(res.data.success) {
                    setMovieList(res.data.movieList)
             } 
        })
        // 성공 시 로그인  페이지로 
        props.history.push(`/login`);
    }
    
    const onEmailChange = (e) => {        
        setEmail(e.currentTarget.value)
    }
    
    const onNameChange = (e) => {        
        setName(e.currentTarget.value)
    }
    
    const onPassWordChange = (e) => {        
        setPassWord(e.currentTarget.value)
    }
    
    const onMessageChange = (e) => {        
        setMessage(e.currentTarget.value)
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
                                <h2>회원가입</h2>
                                <p className="mb-0">약관에 이용확인 후 회원가입</p>
                            </div>                    
                        </div>     
                                           
                        <div className="row">                   
                         
                            <div className="col-md-6 mb-5 mb-md-0" data-aos="fade-up">                    
                                <form onSubmit={onSubmit} role="form" className="php-email-form">                        
                                    <div className="row">
                                    	<div className="col-md-6 form-group">
                                            <label htmlFor="id">ID</label> <input type="text" name="id"
                                            className="form-control" id="id" data-rule="minlen:4"
                                            data-msg="Please enter at least 4 chars" onChange={onIdChange} value={Id} />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-6 form-group">
                                            <label htmlFor="checkDup">중복확인</label> <input type="button" id="checkDup"
                                            className="form-control" onClick={checkDup} />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-6 form-group">
                                            <label htmlFor="name">이름</label> <input type="text" name="name"
                                            className="form-control" id="name" data-rule="minlen:4"
                                            data-msg="Please enter at least 4 chars" onChange={onNameChange} value={Name} />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-6 form-group">
                                            <label htmlFor="email">이메일</label> <input type="email"
                                            className="form-control" name="email" id="email" data-rule="email"
                                            data-msg="Please enter a valid email" onChange={onEmailChange} value={Email} />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-12 form-group">
                                            <label htmlFor="name">비밀번호</label> <input type="password"
                                            className="form-control" id="subject"
                                            data-rule="minlen:4"
                                            data-msg="Please enter at least 8 chars of subject" onChange={onPassWordChange} value={PassWord} />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-12 form-group">
                                            <label htmlFor="name">비밀번호 확인</label> <input type="password"
                                            className="form-control" name="password" id="subject" data-rule="minlen:4"
                                            data-msg="Please enter at least 8 chars of subject" />
                                            <div className="validate"></div>
                                        </div>
                                        <div className="col-md-12 form-group">
                                            <label htmlFor="message">자기소개</label>
                                            <textarea className="form-control" name="message" cols="30" id="message"
                                            rows="10" data-rule="required" onChange={onMessageChange} value={Message}
                                            data-msg="Please write something for us"></textarea>
                                            <div className="validate"></div>
                                        </div>                                 
                                        <div className="col-md-12 mb-3">
                                            <div className="loading">Loading</div>
                                            <div className="error-message"></div>
                                            <div className="sent-message">Your message has been sent. Thank you!</div>
                                        </div>                                        
                                        <div className="col-md-6 form-group">
                                            <input type="submit" onClick={onSubmit} className="readmore d-block w-100" value="회원가입" />
                                        </div>
                                    </div>                                
                                </form>                    
                            </div>
                        
                            <div className="col-md-4 ml-auto order-2" data-aos="fade-up">
                                <ul className="list-unstyled">
                                    <li className="mb-3"><strong className="d-block mb-1">약관</strong>
                                        <span>회원가입 동의 </span>
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

export default JoinPage
