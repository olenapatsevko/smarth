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
 private Double hip;
 private Double waist;
 private Double weight;
 private Double height;
 private Double glucoseBlood;
 private Double glucoseUrine;
 private Double urea;
 private Double creatinine;
 private Double uricAcid;
 private Double totalProteins;
 private Double totalBilirubin;
 private Double directBilirubin;
 private Double cholesterol;
 private Double HDL;
 private Double LDL;
 private Double GDH;
 private Double GGT;
 private Double LDH;
 private Double CRP;
 private Double alkalinePhosphatase;
 private Double ALT;
 private Double AST;
 private Double amylase;
 private Double albumin;
 private Double globulin;
 private Double pH;
 private Double protein;
 private Double density;
 private Double ketoneBodies;
 private Double bilirubin;
 private Double urobilinogen;
 private Double haemoglobin;
 private Double erythrocytes;
 private Double leukocytes;
 private Double epithelialCells;

}
