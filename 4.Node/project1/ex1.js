const f1 = () => {
    console.log('hello');
    f2();
}

const f2 = () => {
    console.log('world');
}

f1();