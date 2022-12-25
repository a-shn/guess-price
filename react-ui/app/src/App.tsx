import React, {useEffect, useState} from 'react';
import './App.css';

function App() {
    const [guess, setGuess] = useState('');
    const [totalScore, setTotalScore] = useState(0);
    const [qNumber, setQNumber] = useState(1)
    const [qTotal, setQTotal] = useState(1)
    const [isGameOver, setGameOver] = useState(false)

    const [q, setQ] = useState({
        imgSource: "",
        description: ""
    });

    const gameOver = () => {
        console.log("GAME IS OVER")
        setGameOver(true)
    }

    const newGame = () => {
        setGameOver(false)
        question()
    }

    const question = () => {
        fetch('http://localhost:8080/get-question', {
            credentials: "include"
        })
            .then(response => response.json())
            .then(result => {
                console.log("Q: " + JSON.stringify(result))
                setQ(result.question)
                setQTotal(result.totalQuestions)
                setQNumber(result.questionNumber)
            });
    }

    const answer = async () => {
        fetch('http://localhost:8080/answer', {
            credentials: "include",
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(guess)
        })
            .then(response => response.json())
            .then(result => {
                setQTotal(result.totalQuestions)
                setQNumber(result.questionNumber)
                if (qTotal > qNumber) {
                    console.log("A: " + JSON.stringify(result))
                    setTotalScore(parseInt(result.totalPoints) + parseInt(result.totalBonusPoints))
                } else {
                    gameOver()
                }
            })
            .then(() => question());
    }

    useEffect(question, [])

    return (
        <div className="App">
            {isGameOver ? (
                <>Game is over, your score: {totalScore}
                    <p><button onClick={newGame}>Start new game</button></p>
                </>
            ) : (
                <><img
                    src={q.imgSource}
                    alt='new'/><p>{q.description} [{qNumber}/{qTotal}]</p><input
                    value={guess}
                    onChange={text => setGuess(text.target.value)}
                    type="numeric"
                    placeholder="Enter your guess"/>
                    <button onClick={answer}>Guess</button>
                    <p>Total Score: {totalScore}</p></>
            )}
        </div>
    );
}


export default App;
