package ru.bogatov.VueApp.Services;

import org.springframework.stereotype.Service;
import ru.bogatov.VueApp.Dao.SellingRepo;
import ru.bogatov.VueApp.Entities.Data;
import ru.bogatov.VueApp.Entities.DataSet;
import ru.bogatov.VueApp.Entities.Selling;
import ru.bogatov.VueApp.Entities.SellingEntry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class StaticService {

    ProductService productService;
    OrderService orderService;
    SellingRepo sellingRepo;

    public StaticService(ProductService productService, OrderService orderService, SellingRepo sellingRepo) {
        this.productService = productService;
        this.orderService = orderService;
        this.sellingRepo = sellingRepo;
    }

    public Data getDataMoney(Date from,Date to){
        Data data = new Data();
        List<String> labels = new ArrayList<>();
        DataSet datasets = new DataSet();
        List<Selling> sellingList = sellingRepo.findAll();
        while(from.before(to)){
            labels.add(transform(from));
            from = addDay(from);
        }
        labels.add(transform(to));

        labels.forEach(x -> {datasets.data.add(0);});
        for(Selling selling : sellingList){
            Date date = selling.getPayDate();
            String dateS = transform(date);
            int index = labels.indexOf(dateS);
            if(index != -1){
                Integer b;
                try{
                     b = datasets.data.get(index);
                }catch (Exception e){
                    b = -2;
                }
                if(b == -2 || b == 0){
                    datasets.data.set(index,(Math.round(selling.calculatePrice())));
                }else{
                    datasets.data.set(index,b + (Math.round(selling.calculatePrice())));
                }
            }

        }
        data.setDatasets(datasets);
        data.setLabels(labels);
        return data;
    }

    public Data getDataProducts(){
        Data data = new Data();
        List<String> labels = new ArrayList<>();
        DataSet datasets = new DataSet();
        List<Selling> sellingList = sellingRepo.findAll();
        for(Selling selling : sellingList){
            for(SellingEntry entry : selling.getSellingEntrySet()){
                String label = entry.getProduct().getName();
                if(labels.indexOf(label) == -1){ //если нету добавим
                    labels.add(label);
                    int index = labels.indexOf(label);
                    datasets.data.add(index,entry.getCount());
                    datasets.backgroundColor.add(index,getRandomColor());

                }else{
                    int index = labels.indexOf(label);
                    Integer old = datasets.data.get(index);
                    datasets.data.set(index,old + entry.getCount());
                }
            }
        }
        data.setLabels(labels);
        data.setDatasets(datasets);
        return data;
    }

    public Data getDataBrands(){
        Data data = new Data();
        List<String> labels = new ArrayList<>();
        DataSet datasets = new DataSet();
        List<Selling> sellingList = sellingRepo.findAll();
        for(Selling selling : sellingList){
            for(SellingEntry entry : selling.getSellingEntrySet()){
                String label = entry.getProduct().getBrandName().getName();
                if(labels.indexOf(label) == -1){ //если нету добавим
                    labels.add(label);
                    int index = labels.indexOf(label);
                    datasets.data.add(index,entry.getCount());
                    datasets.backgroundColor.add(index,getRandomColor());

                }else{
                    int index = labels.indexOf(label);
                    Integer old = datasets.data.get(index);
                    datasets.data.set(index,old + entry.getCount());
                }
            }
        }
        data.setLabels(labels);
        data.setDatasets(datasets);
        return data;
    }

    public String transform(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public Date addDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add( Calendar.DATE, 1 );
        Date date1 = new Date();
        date1.setTime(cal.getTimeInMillis());
        return date1;
    }

    public String getRandomColor(){
        Random random = new Random();
        int red=random.nextInt(256);
        int green=random.nextInt(256);
        int blue=random.nextInt(256);
        return "rgba("+red+", "+green+", "+blue+", 0.7)";
    }
}
