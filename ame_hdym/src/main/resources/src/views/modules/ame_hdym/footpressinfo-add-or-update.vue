<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="ѹfèkg)" prop="footpress">
      <el-input v-model="dataForm.footpress" placeholder="ѹfèkg)"></el-input>
    </el-form-item>
    <el-form-item label="λփèmm)" prop="footout">
      <el-input v-model="dataForm.footout" placeholder="λփèmm)"></el-input>
    </el-form-item>
    <el-form-item label="Ӥֈ܆èmm)" prop="footlength">
      <el-input v-model="dataForm.footlength" placeholder="Ӥֈ܆èmm)"></el-input>
    </el-form-item>
    <el-form-item label="Beta" prop="normalbeta">
      <el-input v-model="dataForm.normalbeta" placeholder="Beta"></el-input>
    </el-form-item>
    <el-form-item label="Theata" prop="normaltheata">
      <el-input v-model="dataForm.normaltheata" placeholder="Theata"></el-input>
    </el-form-item>
    <el-form-item label="Gamma" prop="normalgamma">
      <el-input v-model="dataForm.normalgamma" placeholder="Gamma"></el-input>
    </el-form-item>
    <el-form-item label="λ҆ԫؐƷ1èmm)" prop="normal1">
      <el-input v-model="dataForm.normal1" placeholder="λ҆ԫؐƷ1èmm)"></el-input>
    </el-form-item>
    <el-form-item label="λ҆ԫؐƷ2(mm)" prop="normal2">
      <el-input v-model="dataForm.normal2" placeholder="λ҆ԫؐƷ2(mm)"></el-input>
    </el-form-item>
    <el-form-item label="λ҆ԫؐƷ3(mm)" prop="normal3">
      <el-input v-model="dataForm.normal3" placeholder="λ҆ԫؐƷ3(mm)"></el-input>
    </el-form-item>
    <el-form-item label="λ҆ԫؐƷ4(mm)" prop="normal4">
      <el-input v-model="dataForm.normal4" placeholder="λ҆ԫؐƷ4(mm)"></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          footpress: '',
          footout: '',
          footlength: '',
          normalbeta: '',
          normaltheata: '',
          normalgamma: '',
          normal1: '',
          normal2: '',
          normal3: '',
          normal4: '',
          time: ''
        },
        dataRule: {
          footpress: [
            { required: true, message: 'ѹfèkg)不能为空', trigger: 'blur' }
          ],
          footout: [
            { required: true, message: 'λփèmm)不能为空', trigger: 'blur' }
          ],
          footlength: [
            { required: true, message: 'Ӥֈ܆èmm)不能为空', trigger: 'blur' }
          ],
          normalbeta: [
            { required: true, message: 'Beta不能为空', trigger: 'blur' }
          ],
          normaltheata: [
            { required: true, message: 'Theata不能为空', trigger: 'blur' }
          ],
          normalgamma: [
            { required: true, message: 'Gamma不能为空', trigger: 'blur' }
          ],
          normal1: [
            { required: true, message: 'λ҆ԫؐƷ1èmm)不能为空', trigger: 'blur' }
          ],
          normal2: [
            { required: true, message: 'λ҆ԫؐƷ2(mm)不能为空', trigger: 'blur' }
          ],
          normal3: [
            { required: true, message: 'λ҆ԫؐƷ3(mm)不能为空', trigger: 'blur' }
          ],
          normal4: [
            { required: true, message: 'λ҆ԫؐƷ4(mm)不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/footpressinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.footpress = data.footpressinfo.footpress
                this.dataForm.footout = data.footpressinfo.footout
                this.dataForm.footlength = data.footpressinfo.footlength
                this.dataForm.normalbeta = data.footpressinfo.normalbeta
                this.dataForm.normaltheata = data.footpressinfo.normaltheata
                this.dataForm.normalgamma = data.footpressinfo.normalgamma
                this.dataForm.normal1 = data.footpressinfo.normal1
                this.dataForm.normal2 = data.footpressinfo.normal2
                this.dataForm.normal3 = data.footpressinfo.normal3
                this.dataForm.normal4 = data.footpressinfo.normal4
                this.dataForm.time = data.footpressinfo.time
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/ame_hdym/footpressinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'footpress': this.dataForm.footpress,
                'footout': this.dataForm.footout,
                'footlength': this.dataForm.footlength,
                'normalbeta': this.dataForm.normalbeta,
                'normaltheata': this.dataForm.normaltheata,
                'normalgamma': this.dataForm.normalgamma,
                'normal1': this.dataForm.normal1,
                'normal2': this.dataForm.normal2,
                'normal3': this.dataForm.normal3,
                'normal4': this.dataForm.normal4,
                'time': this.dataForm.time
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
