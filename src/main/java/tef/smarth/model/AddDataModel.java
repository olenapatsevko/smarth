package tef.smarth.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddDataModel {

 private Date date;
 private double hip;
 private double waist;
 private double weight;
 private double height;
 private double glucoseBlood;
 private double glucoseUrine;
 private double urea;
 private double creatinine;
 private double uricAcid;
 private double totalProteins;
 private double totalBilirubin;
 private double directBilirubin;
 private double cholesterol;
 private double HDL;
 private double LDL;
 private double GDH;
 private double GGT;
 private double LDH;
 private double CRP;
 private double alkalinePhosphatase;
 private double ALT;
 private double AST;
 private double amylase;
 private double albumin;
 private double globulin;
 private double pH;
 private double protein;
 private double density;
 private double ketoneBodies;
 private double bilirubin;
 private double urobilinogen;
 private double haemoglobin;
 private double erythrocytes;
 private double leukocytes;
 private double epithelialCells;

}
