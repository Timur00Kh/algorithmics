

/*
* @param {number} num
* */
function happyKazanTicket(num) {
    const numLength = num.toString();
    const last = Math.pow(10, num)

    let time = Date.now()
    for (let i = last / 1000; i < last; i++) {
        const numSum = i.toString()
            .split('')
            .reduce((a, b) => a + parseInt(b), 0);

        if (i % 1000000 === 0) {
            console.log(i / 1000000, `time: ${Date.now() - time};  ${(i / last * 100).toFixed(2)}%`  )
            time = Date.now()
        }
    }
    
    console.log(num, numLength)
}

let t = Date.now()
happyKazanTicket(6)
console.log(new Date(Date.now() - t))