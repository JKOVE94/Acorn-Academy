//ASCII Art pakage with figlet
import figlet from "figlet";

figlet("Node is great package!", (err, data) => {
    if(err){
        console.log('Something went wrong');
        return;
    }
    console.log(data);
})